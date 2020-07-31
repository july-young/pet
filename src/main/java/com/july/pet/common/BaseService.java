package com.july.pet.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.july.pet.exception.PetException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * @author: july
 * @date: 2020/7/31 14:11
 * @description:
 */
public class BaseService<BO extends BaseBO, DO extends BaseDO, Converter extends BaseConverter, Mapper extends BaseMapper> implements BeanFactoryAware, InitializingBean {

    @Autowired
    private BeanFactory beanFactory;
    private Class baseMapperClazz;
    private Class baseConverterClazz;
    private Class boClazz;
    protected Mapper mapper;
    protected Converter converter;


    public BaseService() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType p = (ParameterizedType) t;
        this.boClazz = (Class) p.getActualTypeArguments()[1];
        this.baseConverterClazz = (Class) p.getActualTypeArguments()[2];
        this.baseMapperClazz = (Class) p.getActualTypeArguments()[3];
    }

    @Override
    public final void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        this.mapper = (Mapper) beanFactory.getBean(baseMapperClazz);
        this.converter = (Converter) beanFactory.getBean(baseConverterClazz);
    }

    protected BO add(BO bo) {
        DO d = (DO) this.converter.toDO(bo);
        Date date = new Date();
        d.setGmtCreate(date);
        d.setGmtUpdate(date);
        d.setDeleted(false);
        //todo 新建人、修改人
        int result = mapper.insertSelective(d);
        if (result < 1) {
            throw new PetException(PetExceptionEnum.DB_INSERT_ERROR);
        }
        DO entity = (DO) mapper.selectByPrimaryKey(d.getId());
        return (BO) this.converter.toBO(entity);
    }

    protected BO modify(BO bo) {

        DO d = (DO) this.converter.toDO(bo);
        Date date = new Date();
        d.setGmtUpdate(date);
        d.setDeleted(false);
        //todo 修改人
        int result = mapper.updateByPrimaryKeySelective(d);
        if (result < 1) {
            throw new PetException(PetExceptionEnum.DB_UPDATE_ERROR);
        }
        return findById(d.getId());
    }

    public int remove(long id) throws IllegalAccessException, InstantiationException {
        BaseDO baseDO = (BaseDO) boClazz.newInstance();
        baseDO.setId(id);
        Date date = new Date();
        baseDO.setGmtUpdate(date);
        baseDO.setDeleted(true);
        return mapper.updateByPrimaryKeySelective(baseDO);
    }

    public BO findById(long id) {
        BaseDO baseDO = mapper.selectByPrimaryKey(id);
        if (baseDO == null) {
            throw new PetException(PetExceptionEnum.DATA_NOT_EXISTS);
        }
        return (BO) converter.toBO(baseDO);
    }

    protected PetPage<BO> page(BaseExample example, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 0 : pageNum;
        pageSize = pageSize == null ? PetConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<DO> list = mapper.selectByExample(example);
        List<BO> boList = this.converter.toBO(list);
        return PetPage.getInstance(new PageInfo(boList));
    }

    protected List<BO> list(BaseExample example) {
        PageHelper.startPage(0, PetConstant.MAX_PAGE_SIZE);
        List<DO> list = mapper.selectByExample(example);
        return this.converter.toBO(list);
    }

}
