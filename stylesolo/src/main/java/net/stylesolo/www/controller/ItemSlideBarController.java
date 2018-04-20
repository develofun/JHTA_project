package net.stylesolo.www.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.stylesolo.www.service.ShopItemService;

@Controller
public class ItemSlideBarController {
	@Autowired ShopItemService service;
   @ResponseBody
   @RequestMapping("/itemSlideBar")
   public String slideControl(HttpServletRequest req){
      Cookie[] cookie=req.getCookies();
   //   System.out.println("ÄíÅ°Å©±â:"+cookie.length);
    
      int[] code=new int[6];
      String[] imgName=new String[6];
      int ii=0;
      int length=cookie.length-1;
     
      for(int i=length;i>0;i--){
    //	 System.out.println("l:"+length+",ÄíÅ°°ª:"+cookie[i].getValue());
         if(cookie[i].getValue().length()==6){
        	 System.out.println("ÄíÅ°2:"+cookie[i].getValue());
	    	 Cookie coo=cookie[i];
	         code[ii]=Integer.parseInt(coo.getValue());
	         imgName[ii]=service.sideBar(code[ii]);
	         ii++;
         }
         if(ii>=6)break;
     
      }
      JSONArray ja=new JSONArray();
      for(int i=0;i<ii;i++){
         JSONObject jo=new JSONObject();
         jo.put("code", code[i]);
         jo.put("imgName", imgName[i]);
         ja.add(jo);
      }
      
      
      return ja.toString();
   }
}