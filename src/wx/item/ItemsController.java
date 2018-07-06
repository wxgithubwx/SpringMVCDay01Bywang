package wx.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemsController {

    @RequestMapping("/list")
    public ModelAndView itemList(){
        List<Items> itemsList=new ArrayList<>();
        //商品列表
        Items items_1=new Items();
        items_1.setName("汉堡");
        items_1.setPrice(11f);
        items_1.setDetail("好吃");

        Items items_2=new Items();
        items_2.setName("炸鸡");
        items_2.setPrice(22f);
        items_2.setDetail("想吃");

        itemsList.add(items_1);
        itemsList.add(items_2);

        ModelAndView view=new ModelAndView();
        view.addObject("itemsList",itemsList);
        view.setViewName("WEB-INF/jsp/itemList.jsp");
        return view;
    }
}
