package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;

public class Elements extends BasePage{


    //Buttons
    @FindBy(id = "item-0")
    private WebElement button_text_box;
    @FindBy(id = "submit")
    private WebElement button_form;
    @FindBy(id = "item-1")
    private WebElement button_CheckBox;
    @FindBy(id = "item-2")
    private WebElement button_RadioButton;
    @FindBy(id = "item-3")
    private WebElement button_WebTables;
    @FindBy(id = "item-7")
    private WebElement button_UploadDownload;
    @FindBy(className = "rct-icon-expand-all")
    private WebElement button_expand_all;
    @FindBy(id = "addNewRecordButton")
    private WebElement button_createPerson;
    @FindBy(id = "submit")
    private WebElement button_SubmitForm;
    @FindBy(id = "basic-addon2")
    private WebElement button_seachPerson;
    @FindBy(className = "form-file-label")
    private WebElement button_Upload;
    @FindBy(xpath = "//span[contains(@title,'Delete')]")
    private WebElement delete_Person;


    /*@FindBy(xpath = "//label[contains(@for,'tree-node-notes')]")
    private WebElement button_Notes;*/


    //Insert data inputs
    @FindBy(id = "userForm")
    private WebElement form_text_box;
    @FindBy(id = "userName")
    private WebElement inputUsername;
    @FindBy(id = "userEmail")
    private WebElement inputEmail;
    @FindBy(id = "currentAddress")
    private WebElement inputAddress;
    @FindBy(id = "permanentAddress")
    private WebElement inputPAddress;
    @FindBy(id = "userForm")
    private WebElement formPerson;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement email;
    @FindBy(id = "age")
    private WebElement age;
    @FindBy(id = "salary")
    private WebElement salary;
    @FindBy(id = "department")
    private WebElement department;
    @FindBy(id = "searchBox")
    private WebElement input_Search;


    public Elements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean openTextBox(String username, String email, String address, String paddress, boolean validate){

        button_text_box.click();
        typeOnElement(inputUsername,username);
        typeOnElement(inputEmail,email);
        typeOnElement(inputAddress,address);
        typeOnElement(inputPAddress,paddress);
        scrollPage();
        button_form.click();
        if(validate == true){
            verifyObject();
            return true;
        }
        if(driver.findElements(By.className("field-error")).size() != 0){
            return false;
        }
        return true;
    }

    public boolean verifyObject(){

        if(driver.findElements(By.className("mb-1")).size() == 4){
            System.out.println("Primer prueba");
            return true;
        }
        System.out.println("Segunda prueba");
        return false;
    }

    public boolean openCheckBox() {
        ArrayList<String> elements = new ArrayList<>();
        elements.add("notes");
        elements.add("react");
        elements.add("private");
        button_CheckBox.click();
        button_expand_all.click();
        scrollPage();
        for (int i = 0; i < elements.size(); i++) {
            driver.findElement(By.xpath("//label[contains(@for,'tree-node-"+elements.get(i)+"')]")).click();
        }
        boolean validateText = validateTextElements("text-success", elements);
        if(validateText){
            delete_Person.click();
            return true;
        }
        return false;
    }

    public boolean openRadioButtonYes() {
        button_RadioButton.click();
        driver.findElement(By.xpath("//label[contains(@for,'yesRadio')]")).click();
        if(driver.findElements(By.className("text-success")).get(0).equals("Yes")){
            return true;
        }
        return false;
    }

    public boolean openRadioButtonNo() {
        button_RadioButton.click();
        driver.findElement(By.xpath("//label[contains(@for,'noRadio')]")).click();
        if(driver.findElements(By.className("text-success")).size() == 0){
            return true;
        }
        return false;
    }

    public boolean openWebTables(){
        button_WebTables.click();
        button_createPerson.click();
        waitForElementToBeVisibled(formPerson);
        fillForm("Manuel", "Amores", "manuelamores25@gmail.com","32","200000","Desarrollo");
        button_SubmitForm.click();
        typeOnElement(input_Search,"manuelamores25@gmail.com");
        button_seachPerson.click();
        WebElement valor= driver.findElements(By.className("rt-tr-group")).get(0).findElement(By.xpath("//div[contains(text(),'manuelamores25@gmail.com')]"));
        if(searchPerson(valor) != null){
            delete_Person.click();
            return true;
        }
        return false;

    }

    public boolean uploadFile(){
        scrollPage();
        button_UploadDownload.click();
        button_Upload.click();
        return true;
    }

    public WebElement searchPerson(WebElement valor){
        if(valor != null){
            if(valor.getText().equals("manuelamores25@gmail.com")){
                return valor;
            }
        }
        System.out.println("No existe el elemento");
        return null;
    }

    public void scrollPage(){
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public boolean validateTextElements(String nameClass, ArrayList nameText){
        ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(By.className(nameClass)));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText().toString());
            System.out.println(nameText.get(i));
            if(!elements.get(i).getText().equals(nameText.get(i))){
                return false;
            }
        }
        return true;
    }

    public boolean fillForm(String fName, String lName, String email, String age, String salary, String deparment){
        typeOnElement(firstName,fName);
        typeOnElement(lastName,lName);
        typeOnElement(this.email,email);
        typeOnElement(this.age,age);
        typeOnElement(this.salary,salary);
        typeOnElement(this.department,deparment);
        return false;
    }
}
