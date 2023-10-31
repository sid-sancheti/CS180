package Midterm2;

import java.util.ArrayList;

public class VideoGame implements AnimatedProject {
    private String projectName;
    private int employeeCount;
    private boolean priority;

    public VideoGame(String projectName, int employeeCount, boolean priority) {
        if (projectName == null)
            throw new NullPointerException();

        if (employeeCount < 0)
            throw new IllegalArgumentException();

        this.projectName = projectName;
        this.employeeCount = employeeCount;
        this.priority = priority;
    }

    public String getProjectName() { return projectName; }
    public int getEmployeeCount() { return employeeCount; }
    public boolean hasPriority() { return priority; }

    public double calculateCostEstimate(double averageSalary, int months) {
        double cost = averageSalary * employeeCount * months;

        if (priority)
            cost *= 1.1;

        return cost;
    }

    public String[] findSimilarProjects(AnimatedProject[] animatedProjects, int employeeThreshold) {
        ArrayList<String> similarProjects = new ArrayList<String>();
        for (AnimatedProject animatedProject: animatedProjects) {
            if (animatedProject instanceof VideoGame && Math.abs(animatedProject.getEmployeeCount() - employeeCount) <= employeeThreshold) {
                similarProjects.add(animatedProject.getProjectName());
            }
        }
        
        String[] projects = new String[similarProjects.size()];
        for (int i = 0; i < similarProjects.size(); i++) {
            projects[i] = similarProjects.get(i);
        }
        return projects;
    }


}
