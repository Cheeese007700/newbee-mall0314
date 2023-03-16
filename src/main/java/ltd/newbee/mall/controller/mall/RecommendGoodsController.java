package ltd.newbee.mall.controller.mall;
import java.util.ArrayList;
import java.util.List;
import ltd.newbee.mall.controller.vo.NewBeeMallIndexConfigGoodsVO;
import ltd.newbee.mall.entity.RecommendGoods;
import ltd.newbee.mall.service.RecommendGoodsService;
import ltd.newbee.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommend")
public class RecommendGoodsController {

    @Autowired
    private RecommendGoodsService recommendGoodsService;

    @GetMapping("/list")
    public String list(Model model, PageQueryUtil pageUtil) {
        List<RecommendGoods> recommendGoodsList = recommendGoodsService.findRecommendGoodsList(pageUtil);
        List<NewBeeMallIndexConfigGoodsVO> recommendGoodsVOList = new ArrayList<>();
        // 将 RecommendGoods 转换成 NewBeeMallIndexConfigGoodsVO
        for (RecommendGoods recommendGoods : recommendGoodsList) {
            NewBeeMallIndexConfigGoodsVO recommendGoodsVO = new NewBeeMallIndexConfigGoodsVO();
            recommendGoodsVO.setGoodsIntro(((RecommendGoods) recommendGoods).getGoodsInfo());
            recommendGoodsVO.setGoodsCoverImg(recommendGoods.getGoodsImage());
            recommendGoodsVO.setSellingPrice(recommendGoods.getSellingPrice());
            recommendGoodsVOList.add(recommendGoodsVO);
        }
        model.addAttribute("recommendGoodsList", recommendGoodsVOList);
        model.addAttribute("pageUtil", pageUtil);
        return "recommendGoods/list";
    }

}
