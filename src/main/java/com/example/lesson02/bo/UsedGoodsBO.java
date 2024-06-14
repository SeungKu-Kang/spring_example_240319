package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service	// spring bean
public class UsedGoodsBO {

	// field
	// Spring bean을 Autowired를 통해서 가져온다.
	@Autowired // Dependency Inject(DI)
	private UsedGoodsMapper usedGoodsMapper;
	
	// input : X (컨트롤러로부터 들어온 요청)
	// output : (Repository한테 받은 것을) List<UsedGoods> (컨트롤러한테 줌)
	public List<UsedGoods> getUsedGoodsList() {
		// List<UsedGoods> usedGoodsList =  usedGoodsMapper.selectUsedGoodsList();
		// return usedGoodsList; // return값은 Controller한테 넘어가게 됨
		return usedGoodsMapper.selectUsedGoodsList(); // 위와 동일한 코드
	}
}
