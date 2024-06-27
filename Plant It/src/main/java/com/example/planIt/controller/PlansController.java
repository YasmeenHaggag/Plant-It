package com.example.planIt.controller;

import com.example.planIt.model.Plan;
import com.example.planIt.service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plans")
public class PlansController {
    @Autowired
    PlansService plansService;

    @PostMapping()
    public void addPlan(@RequestBody (required = false) Plan plan){
        plansService.addPlan(plan);
    }
    @PostMapping("/{planId}/{item}")
    public void addPlanItem(@PathVariable String planId,
                            @PathVariable String item){
        plansService.addItem(planId,item);
    }

    @DeleteMapping
    public void deletePlan(
                           @RequestParam String planId,
                           @RequestParam (required = false) String item){
        if(item!=null && !item.isEmpty())
            plansService.deleteItem(planId,item);
        else {
            plansService.deletePlan(planId);
        }
    }

    @GetMapping
    public List<Plan> getUserPlans(@RequestParam String userId)
    {
           return plansService.getPlansByUserId(userId);
    }
    @GetMapping("/ByPlanId")
    public List<String> getPlans(@RequestParam String planId)
    {
        return plansService.getPlanByPlanId(planId);
    }

}
