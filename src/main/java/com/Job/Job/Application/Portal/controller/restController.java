package com.Job.Job.Application.Portal.controller;

import com.Job.Job.Application.Portal.model.jobPost;
import com.Job.Job.Application.Portal.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class restController
{
    @Autowired
    private jobService Service;

    @GetMapping("jobPosts")
    public List<jobPost>getAllJobs()
    {
      return Service.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    public jobPost getJob(@PathVariable("postId") int postId)
    {
      return Service.getJob(postId);
    }
    @PostMapping("jobPost")
    public jobPost addJob(@RequestBody jobPost jobPost)
    {
        Service.addJob(jobPost);
        return jobPost;
    }
    @PutMapping("jobPost")
    public jobPost updateJob(@RequestBody jobPost jobPost)
    {
        Service.updateJob(jobPost);
        return jobPost;
    }
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        Service.deleteJob(postId);
        return "Deleted";
    }
    @GetMapping("jobpost/keyword/{keyword}")
    public List<jobPost> findByName(@PathVariable("keyword") String keyword)
    {
       return Service.search(keyword);
    }
    @GetMapping("load")
    public String loadData()
    {
        Service.loadData();
        return "Success";
    }
}
