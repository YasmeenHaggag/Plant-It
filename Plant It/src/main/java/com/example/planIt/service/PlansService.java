package com.example.planIt.service;

import com.example.planIt.model.Plan;
import com.example.planIt.repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlansService {
    @Autowired
    PlansRepository plansRepository;
    public void addPlan(Plan plan){
        plansRepository.save(plan);
    }
    public void deletePlan(String planId){
        plansRepository.deleteById(planId);
    }
    public List<Plan> getPlansByUserId(String userId){
        return plansRepository.findPlansByUserId(userId);
    }
    public List<String> getPlanByPlanId(String planId){
         return plansRepository.findById(planId).get().getPlanItems();
    }
    public void deleteItem(String planId,String itemName){
        Plan plan=plansRepository.findById(planId).get();
        plan.getPlanItems().remove(itemName);
        plansRepository.save(plan);
    }
    public void addItem(String planId,String item){
        Plan plan=plansRepository.findById(planId).get();
        plan.getPlanItems().add(item);
        plansRepository.save(plan);
    }
}
