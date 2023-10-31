package Midterm2;

public interface AnimatedProject {
    String getProjectName();
    int getEmployeeCount();
    boolean hasPriority();
    public double calculateCostEstimate(double averageSalary, int months);
    String[] findSimilarProjects(AnimatedProject[] animatedProjects, int employeeThreshold);
}
