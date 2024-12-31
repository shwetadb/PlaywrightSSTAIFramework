package com.qa.sstaiframework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class Navigate_Modules extends LoginProcess {

    //1.  Locators
    private String createNewProjectBtn = "//button[normalize-space()='Create New Project']";
    private String createNewProjectHeading = "//h4[normalize-space()='Create New Project']";
    private String agentBtn = "//button[normalize-space()='Agents']";
    private String agentScreenHeading = "//h4[normalize-space()='Select Agent']";
    private String modelsBtn = "//button[normalize-space()='Models']";
    private String modelsScreenHeading = "//h4[normalize-space()='Models']";
    private String costingBtn = "//button[normalize-space()='Costing']";
    private String costingScreenHeading = "//h5[normalize-space()='Costing']";
    private String policyBtn = "//button[normalize-space()='Policy']";
    private String policyScreenHeading = "//h4[normalize-space()='Group of rules']";
    private String containerServicesBtn = "//button[normalize-space()='Container Services']";
    private String containerServicesScreenHeading = "//h3[normalize-space()='Container Services']";
    private String trainAgentBtn = "//button[normalize-space()='Train Agent']";
    private String trainAgentScreenHeading ="//h4[normalize-space()='Trained Agents']";
    private String chatBtn = "//button[normalize-space()='Chat']";
    private String chatScreenHeading = "//h3[normalize-space()='SSTAI Virtual Assistant']";
    private String logoutBtn = "//button[normalize-space()='Log Out']";
    private String pickAccount = "//div[@role='heading']";
    private String account = "//div[@aria-label='Sign out Shweta.Paskanti@sstus.net work or school account.']";
    
    

    //2. Constructor
    public Navigate_Modules(Page page) {
        super(page); // Call parent class constructor
    }

    //3. Methods
    //Create New Project Methods
    public void clickCreateNewProject() {
        page.click(createNewProjectBtn); // Click the "Agents" button
        try {
    	    page.waitForLoadState(LoadState.NETWORKIDLE);
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Create New Project");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isCreateNewProjectVisible() {
    	 page.waitForSelector(createNewProjectHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(createNewProjectHeading); 
    }
    
    
    
    //Agent Methods
    public void clickAgent() {
        page.click(agentBtn); // Click the "Agents" button
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Agent");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isAgentScreenVisible() {
   	 page.waitForSelector(agentScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
     return page.innerText(agentScreenHeading); 
    }
    
    
    //Models Methods
    public void clickModels() {
        page.click(modelsBtn); 
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Models");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isModelsScreenVisible() {
      	 page.waitForSelector(modelsScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(modelsScreenHeading); 
    }
    
    
    //Costing Methods
    public void clickCosting() {
        page.click(costingBtn); 
        try {
            Thread.sleep(5000); 
            System.out.println("Clicked → Costing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isCostingScreenVisible() {
      	 page.waitForSelector(costingScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(costingScreenHeading); 
    }
    
    //Policy Methods
    public void clickPolicy() {
        page.click(policyBtn);
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Policies");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isPolicyScreenVisible() {
      	 page.waitForSelector(policyScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(policyScreenHeading); 
    }
    
    //ContainerServices Methods
    public void clickContainerServices() {
        page.click(containerServicesBtn);
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Container Services");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isContainerServicesScreenVisible() {
      	 page.waitForSelector(containerServicesScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(containerServicesScreenHeading); 
    }
    
    
    //TrainAgents Methods
    public void clickTrainAgents() {
        page.click(trainAgentBtn);
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Train Agents");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isTrainAgentsScreenVisible() {
      	 page.waitForSelector(trainAgentScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(trainAgentScreenHeading); 
    }
    
    //Chat Methods
    public void clickChat() {
        page.click(chatBtn);
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Chat");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isChatScreenVisible() {
      	 page.waitForSelector(chatScreenHeading, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(chatScreenHeading); 
    }
    
    
    //Logout Methods
    public void clickLogout() {
        page.click(logoutBtn);
        try {
            Thread.sleep(5000); // Wait for 1 second
            System.out.println("Clicked → Logout");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String isPickAccountVisible() {
      	 page.waitForSelector(pickAccount, new Page.WaitForSelectorOptions().setTimeout(10000)); // Wait for visibility
         return page.innerText(pickAccount); 
    }
    
    public boolean clickAccount() {
    	page.click(account);
		if(page.isVisible(logintoMicrosoftBtn)) {
			System.out.println("Logged in Sucessfully........");
			return true;
		}
		return false;
    }
    
    
    
    
    
    
    
    
    
    
    
}
