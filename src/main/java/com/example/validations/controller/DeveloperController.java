package com.example.validations.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.validations.entity.Developer;
import com.example.validations.pojo.ConditionalCustomValidation;
import com.example.validations.service.DeveloperService;
import com.example.validations.validators.CreateDeveloper;
import com.example.validations.validators.UpdateDeveloper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated
@Api(value="DeveloperManager", description="Developer Manager API",
tags="DeveloperManager")
public class DeveloperController {
	
	private final DeveloperService developerService;
	
	public DeveloperController(DeveloperService developerService)
	{
		this.developerService = developerService;
	}
	
	@ApiOperation(value="Get All Developers",nickname="getAllDevelopers",notes="",
			response=Developer.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="Developer found",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid Developer"),
			@io.swagger.annotations.ApiResponse(code=404,message="Developers not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@GetMapping("/")
	public List<Developer> getAllDevelopers()
	{
		return developerService.getAllDevelopers();
	}
	
	@ApiOperation(value="Post Developers",nickname="createDeveloper",notes="",
			response=Developer.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="Developer created",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid Developer"),
			@io.swagger.annotations.ApiResponse(code=404,message="Developer not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@PostMapping("/add")
	@Validated(CreateDeveloper.class)
	public Developer createDeveloper(@RequestBody @Valid Developer developer)
	{
		return developerService.createDeveloper(developer);
	}
	
	@ApiOperation(value="Post ConditionalCustomValidation",nickname="createCustomValidation",notes="",
			response=ConditionalCustomValidation.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="CustomValidatio created",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid CustomValidatio"),
			@io.swagger.annotations.ApiResponse(code=404,message="CustomValidatio not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@PostMapping("/customValidation")
	@Validated(CreateDeveloper.class)
	public String createCustomValidation(@RequestBody @Valid ConditionalCustomValidation custom)
	{
		return "Validated";
	}
	
	@ApiOperation(value="Put Developers",nickname="updateDeveloper",notes="",
			response=Developer.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="Developer updated",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid Developer"),
			@io.swagger.annotations.ApiResponse(code=404,message="Developer not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@PutMapping("/update/{devId}")
	@Validated(UpdateDeveloper.class)
	public ResponseEntity<Developer> updateDeveloper(@PathVariable(value="devId")Long devId,
			@Valid @RequestBody Developer developer)
	{
		return developerService.updateDeveloper(devId,developer);
	}
	
	@ApiOperation(value="Delete Developers",nickname="deleteDeveloper",notes="",
			response=Developer.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="Developer updated",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid Developer"),
			@io.swagger.annotations.ApiResponse(code=404,message="Developer not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@DeleteMapping("/delete/{devId}")
	@Validated(UpdateDeveloper.class)
	public String deleteDeveloper(@PathVariable(value="devId")Long devId)
	{
		return developerService.deleteDeveloper(devId);
	}
	
	@ApiOperation(value="Delete Developers",nickname="deleteDeveloper",notes="",
			response=Developer.class,responseContainer="list",tags= {"DeveloperManager"})
	@ApiResponses(value= {
			@io.swagger.annotations.ApiResponse(code=200,message="Developer updated",response=Developer.class,responseContainer="List"),
			@io.swagger.annotations.ApiResponse(code=400,message="Invalid Developer"),
			@io.swagger.annotations.ApiResponse(code=404,message="Developer not found"),
			@io.swagger.annotations.ApiResponse(code=500,message="Internal Server Error")})
	@DeleteMapping("/deleteChild/{sNo}")
	public String deleteChildDeveloper(@PathVariable(value="sNo")Long sNo)
	{
		return developerService.deleteChildDeveloper(sNo);
	}

}
