package com.example.asmjavaspring.controller;

import com.example.asmjavaspring.entity.District;
import com.example.asmjavaspring.entity.Street;
import com.example.asmjavaspring.server.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/seed/generate")
public class SeedController {

    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.POST)
    public String seed(){
        District district1 = new District("Bắc Từ Liêm");
        district1.addStreet(new Street("Hồ Tùng Mậu", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa", (int) random(0, 2),district1));
        district1.addStreet(new Street("Văn Tiến Dũng", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa", (int) random(0, 2),district1));
        District district2 = new District("Nam Từ Liêm");
        district2.addStreet(new Street("Lê Đức Thọ", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa", (int) random(0, 2),district2));
        district2.addStreet(new Street("Trần Hữu Dực", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa",(int) random(0, 2),district2));
        District district3 = new District("Cầu Giấy");
        district3.addStreet(new Street("Xuân Thủy", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa", (int) random(0,2),district3));
        district3.addStreet(new Street("Liễu Giai", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa",(int) random(0,2),district3));
        District district4 = new District("Hai Bà Trưng");
        district4.addStreet(new Street("Trần Khát Chân", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa",(int) random(0,2),district4));
        district4.addStreet(new Street("Minh Khai", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đã từng là con đường đẹp nhất Hà Nội, giờ tắc gần nhất",(int) random(0,2),district4));
        District district5 = new District("Đống Đa");
        district5.addStreet(new Street("Đường Láng", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"1 trong số những con đường tắc nhất của Hà Nội",(int) random(0,2),district5));
        district5.addStreet(new Street("Xã Đàn", Calendar.getInstance().getTimeInMillis()- random(10,20)*365*86400000,"Đường bê tông nhựa",(int) random(0,2),district5));
        List<District> districts = Arrays.asList(district1, district2, district3, district4,district5);
        districtService.saveAll(districts);
        return "thành công";
    }

    public long random(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
