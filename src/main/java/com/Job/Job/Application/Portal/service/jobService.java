package com.Job.Job.Application.Portal.service;

import com.Job.Job.Application.Portal.model.jobPost;
import com.Job.Job.Application.Portal.repo.jobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class jobService
{
    @Autowired
    private jobRepo repo;

    public List<jobPost> getAllJobs()
    {
       return repo.findAll();
    }
    public jobPost getJob(int postId)
    {
        return repo.findById(postId).orElse(new jobPost());
    }
    public void addJob(jobPost jobPost)
    {
        repo.save(jobPost);
    }

    public void loadData()
    {
        List<jobPost> jobs=
                new ArrayList<>(List.of(
                        new jobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new jobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new jobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new jobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new jobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
                ));
        repo.saveAll(jobs);
    }

    public void updateJob(jobPost jobPost)
    {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public List<jobPost> search(String keyword)
    {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
