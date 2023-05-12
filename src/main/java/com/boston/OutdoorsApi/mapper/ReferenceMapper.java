//package com.boston.OutdoorsApi.mapper;
//
//import javax.persistence.EntityManager;
//import org.springframework.stereotype.Component;
//
//import java.util.logging.Logger;
//
//@Component
//public class ReferenceMapper {
//
//
//    private final EntityManager em;
//    Logger logger = Logger.getLogger(ReferenceMapper.class.getName());
//`
//    public ReferenceMapper(EntityManager em) {
//        this.em = em;
//    }
//
////    @ObjectFactory
////    public <T extends AbstractEntity<?>> T resolve(AbstractDTO<?> sourceDTO,
////                                                   @TargetType Class<T> type) {
////        T entity = null;
////        if (sourceDTO.getId() != null) entity = em.find(type, sourceDTO.getId());
////        try {
////            if (entity == null) {
////                entity = type.getDeclaredConstructor().newInstance();
////            }
////        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
////                 NoSuchMethodException e) {
////            logger.error(e.getMessage());
////        }
////        return entity;
////    }
//}