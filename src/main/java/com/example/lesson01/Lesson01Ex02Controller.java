package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다 !! -> 태그같은것들이 response에 바로 들어가기 때문
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // --1
	public String ex02() {
		// return 되는 String은 html의 경로이다.(@ResponseBody가 없을 때)
		
		// return "           lesson01/ex02 "; -> 공통된 주소는 생략
		// return "/templates/lesson01/ex02.html"
		return "lesson01/ex02"; // response html view 경로 --2
		// 1과 2는 아무런 연관성이 없다.
	}
}
