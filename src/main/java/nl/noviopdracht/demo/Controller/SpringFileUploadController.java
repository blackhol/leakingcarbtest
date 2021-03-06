package nl.noviopdracht.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import nl.noviopdracht.demo.DTO.CarDTO;
import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.Car;
import nl.noviopdracht.demo.Model.User;
import nl.noviopdracht.demo.Service.CarService;
import nl.noviopdracht.demo.Service.UploadPathService;
import nl.noviopdracht.demo.Service.UserService;
import nl.noviopdracht.demo.files.Carfiles;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class SpringFileUploadController {

    @Autowired
    UploadPathService uploadPathService;
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/carpaper")
    public String car(Model model) {
        ArrayList<CarDTO> cars = carService.getAllCars();
        ArrayList<UserDTO> users = userService.gettAllUsers();
        model.addAttribute("cars", cars);
        model.addAttribute("car", new Car());
        model.addAttribute("carfiles", new ArrayList<Carfiles>());
        model.addAttribute("isAdd", true);
        model.addAttribute("users", users);
        model.addAttribute("user", new User());

        return "/add_car_paper";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Car car, User user, RedirectAttributes redirectAttributes, Model model) {
        car.setOwnerID(user.getId());
        Car dbCar = carService.save(car);

        if (dbCar != null) {
            redirectAttributes.addFlashAttribute("successmessage", "Car is saved succesfully");
            return "redirect:/carpaper";
        } else {
            model.addAttribute("errormessage", "car is not saved, please try again");
            model.addAttribute("car", car);
            return "view/car";
        }
    }


    @GetMapping(value = "/editcar/{carID}")
    public String editcar(@PathVariable Long carID,Model model) {
        Car car = carService.findById(carID);
        List<Carfiles> carfiles = carService.findFilesByUserId(carID);


        ArrayList<CarDTO> cars = carService.getAllCars();

        ArrayList<UserDTO> users = userService.gettAllUsers();

        model.addAttribute("cars", cars);
        model.addAttribute("car", car);
        model.addAttribute("carfiles", carfiles);
        model.addAttribute("isAdd", false);

        model.addAttribute("users", users);
        model.addAttribute("user", new User());

        return "/add_car_paper";
    }
    @PostMapping(value = "/update")
    public String update(@ModelAttribute Car car, User user, RedirectAttributes redirectAttributes, Model model) {
        car.setOwnerID(user.getId());
        log.info("SpringFileUploadController:" + car.toString());
        Car dbCar = carService.updateCar(car);

        if (dbCar != null) {
            redirectAttributes.addFlashAttribute("updatemessage", "Car is updated succesfully");
            return "redirect:/carpaper";
        } else {
            model.addAttribute("errormessage", "car is not updated, please try again");
            model.addAttribute("car", car);
            return "view/car";
        }
    }


}
