package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
    class Monservice {
        public CarRepository carRepository;
        @Autowired
        public void MonServeur(CarRepository carRepository){
            System.out.println( carRepository);
            this.carRepository=carRepository;
            Car car = new Car();
            car.setMarque("BMW");
            car.setPlateNumber("AA123AA");
            carRepository.save(car);
        }
        //ArrayList<Car> cars = new ArrayList<Car>();
        @ResponseStatus(value = HttpStatus.NOT_FOUND , reason="car not found")//404
        @ExceptionHandler(Exception.class)
        public void erreur(){
            System.out.println("ici");
        }
        @GetMapping("/cars/{plateNumber}")
        public Car liste(
                @PathVariable("plateNumber") String plateNumber,
                @RequestParam(value = "rent", required = true) boolean rent) throws Exception {

            System.out.println(plateNumber);
            System.out.println(rent);
           return carRepository.findByPlateNumber(plateNumber);

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


