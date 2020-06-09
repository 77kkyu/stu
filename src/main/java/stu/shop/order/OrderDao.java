package stu.shop.order;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import stu.common.common.CommandMap;
import stu.common.dao.AbstractDao;

@Repository("orderDao")
public class OrderDao extends AbstractDao{
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> orderMemberInfo(CommandMap commandMap) throws Exception{
		return (Map<String, Object>) selectOne("order.orderMemberInfo", commandMap.getMap());
	}

	public List<Map<String, Object>> memberCoupon(CommandMap commandMap) {
		return (List<Map<String,Object>>) selectList("order.memberCoupon", commandMap.getMap());
	}

	public void insertOrder(CommandMap commandMap) throws Exception{
		insert("order.insertOrder", commandMap.getMap());
		insert("order.insertOrderDetail", commandMap.getMap());
		insert("order.savePoint", commandMap.getMap());
		insert("order.usePoint", commandMap.getMap());
		update("order.useCoupon", commandMap.getMap());
	}
	
	
	
	
}
