package com.example.demo;

import org.assertj.core.internal.Dates;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
class Monservice {
    CarRepository carRepository;
    @Automired
    public Monservice (CarRepository car){
        System.out.println(car);
        this.carRepository = car;
    }
    ArrayList<Car> cars = new ArrayList<Car>();
    @ResponseStatus(value = HttpStatus.NOT_FOUND , reason="car not found")//404
    @ExceptionHandler(Exception.class)
    public void erreur(){
        System.out.println("ici");
    }
    @GetMapping("/cars/{plateNumber}")
    public String liste(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value = "rent", required = true) boolean rent) throws Exception {

        System.out.println(plateNumber);
        System.out.println(rent);
        for(Car car: cars){
            if(car.getPlateNumber().equals(plateNumber)){
                // ....
                return "erreur";
            }
        }
        throw new Exception();
    }
    @PutMapping("/cars")
    public void louer(@RequestBody Dates dates){
        System.out.println(dates);
    }
    @PostMapping("/cars")
    public void addCar(@RequestBody Car car ){
        carRepository.save(car) ;
    }
}
