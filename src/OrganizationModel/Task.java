/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrganizationModel;

/**
 *
 * @author Magical Me
 */
public class Task {
    private String taskId;
	private String description;
	
	Task(String _taskId, String _description) 
	{
		taskId = _taskId;
		description = _description;
	}

	public String getTaskId() 
	{
		return this.taskId;
	}

	public String getDescription() 
	{
		return this.description;
	}

	@Override
	public String toString() 
	{
		return "Task [taskId=" + taskId + ", description=" + description + "]";
	}
}
