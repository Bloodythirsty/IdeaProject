package cn.kk.controller;

import cn.kk.pojo.Place;
import cn.kk.pojo.Result;
import cn.kk.service.IPlaceService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("place")
@Slf4j
@CrossOrigin
public class PlaceController {

    @Autowired
    private IPlaceService  placeService;

    @GetMapping("{provinceId}")
    public Result findPlacesByProvinceId(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                         @RequestParam(name = "pageSize",defaultValue = "2")Integer pageSize,
                                         @PathVariable(name = "provinceId")Integer provinceId){
        Result result = new Result();
        try{
            List<Place> placeList = placeService.findPlaceByProvinceId(page, pageSize, provinceId);
            PageInfo<Place> placePageInfo = new PageInfo<>(placeList);
            result.setPlacePageInfo(placePageInfo).setState(true).setMsg("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setState(false);
        }
        return result;
    }

    @PostMapping
    public Result savePlace(Place place){
        Result result = new Result();
        try{
            placeService.savePlace(place);
            result.setState(true).setMsg("添加景点成功~");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }

        return result;
    }
}
