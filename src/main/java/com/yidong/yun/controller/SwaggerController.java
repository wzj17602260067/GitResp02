package com.yidong.yun.controller;


import com.yidong.yun.pojo.Zy;
import com.yidong.yun.response.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "控制层")
@RestController
public class SwaggerController {

        @ApiImplicitParams({
                @ApiImplicitParam( name = "id", value ="序号", paramType = "query", dataType = "Integer"),
                @ApiImplicitParam( name = "name", value ="姓名", paramType = "query", dataType = "String")
        })
        @GetMapping("/path")
        public String getSwagger(@RequestParam("id") Integer id,@RequestParam("name") String name){
             return name;
        }


        @GetMapping("/Rvo")
        public ResponseVo  getResponse(){

                Zy zy = new Zy();
                return ResponseVo.success(zy);

        }

        @GetMapping("/Bvo")
        public ResponseVo  getReBuilder(){

                Zy zy = new Zy();

                ResponseVo.ResponseVoBuilder<Zy> zyResponseVoBuilder = ResponseVo.successBu(zy);

                zyResponseVoBuilder.entity(zy);

                return zyResponseVoBuilder.build();

        }



}
