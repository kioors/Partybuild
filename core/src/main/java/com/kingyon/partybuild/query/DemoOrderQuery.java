//package com.kingyon.partybuild.query;
//
//import com.kingyon.drive.domain.order.Order;
//import com.kingyon.drive.domain.order.OrderStatus;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * com.kingyon.drive.query
// * <p/>
// *
// * @author <a href="libing@kingyon.com">XiaoDong Yuan</a>
// *         2017/8/10 0010
// * @since 0.1.0
// */
//public class DemoOrderQuery implements Specification<Order> {
//
//    //用户
//    private Long memberId;
//
//    private Integer orderStatus;
//
//    //是否删除
//    private Boolean del;
//
//    @Override
//    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        List<Predicate> list = new LinkedList<>();
//
//        list.add(criteriaBuilder.equal(root.get("deleted").as(Boolean.class),false));
//
//        if (memberId!=null){
//            list.add(criteriaBuilder.equal(root.get("member").get("id").as(Long.class),memberId));
//        }
//        if(orderStatus != null){
//            //已完成->完成,取消,清算
//            if(orderStatus == 6){
//                list.add(criteriaBuilder.or(
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.FINISHED),
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.SETTLED),
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.CANCELED)
//                ));
//            }
//            //待确认->已预约,待反馈
//            else if (orderStatus == 1) {
//                list.add(criteriaBuilder.or(
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.CONFIRM),
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.FEEDBACK)
//                ));
//            }
//            //进行中->已确认,进行中,待付款
//            else if (orderStatus == 3){
//                list.add(criteriaBuilder.or(
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.CONFIRMED),
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.PROGRESS),
//                        criteriaBuilder.equal(root.get("status").as(OrderStatus.class), OrderStatus.PAYMENT)
//                ));
//            } else {
//                list.add(criteriaBuilder.equal(root.get("status").as(Long.class),orderStatus));
//            }
//        }
//
//        if (del!=null){
//            list.add(criteriaBuilder.equal(root.get("deleted").as(Boolean.class),del));
//        }
//        Predicate[] p = new Predicate[list.size()];
//        return criteriaBuilder.and(list.toArray(p));
//    }
//
//    public DemoOrderQuery() {
//
//    }
//
//    public DemoOrderQuery(Long memberId, Integer orderStatus) {
//        setMemberId(memberId);
//        setOrderStatus(orderStatus);
//    }
//
//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//    public Integer getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(Integer orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    public Boolean getDel() {
//        return del;
//    }
//
//    public void setDel(Boolean del) {
//        this.del = del;
//    }
//}
