package stepDef;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AsusFeatureTest_StepDef extends BaseTest {

    @Given("^user is on selenium practice home page$")
    public void user_on_Selenium_Practice_Page() {
        String url = System.getProperty("user.dir") + "/src/main/resources/selPractice.htm";
        getDriver().get("file://" + url);
    }

    @Then("^user enters \"(.*?)\" on text box$")
    public void enter_text(String text) {
        getDriver().findElement(By.id("textinput")).sendKeys(text);
    }

    @Then("^user selects value from Select drop down$")
    public void selectValue() throws Exception {
        Select dd = new Select(getDriver().findElement(By.name("PASAM")));
        List<WebElement> ddl = dd.getOptions();
        for (int i = 0; i < ddl.size(); i++) {
            System.out.println("Dropdown: " + (i + 1) + " Option: " + ddl.get(i).getText() + " Status: " + ddl.get(i).isSelected());
        }
        Thread.sleep(2000);
        dd.selectByIndex(1);
        Thread.sleep(2000);
        dd.selectByIndex(ddl.size() - 1);
        getDriver().findElement(By.xpath("//select[@id='PASAM1']/option[@value='amlu' and .='Amlan']")).click();
    }

    @Then("click on Home")
    public void clickHome() throws Exception {
        WebElement homeLink = getDriver().findElement(By.xpath(".//a[contains(text(),'Home')]"));
        Actions act1 = new Actions(getDriver());
        Thread.sleep(3000);
        act1.moveToElement(homeLink).perform();
    }

    @Then("^user enters \"(.*?)\" on username$")
    public void setUserName(String text) {
        getDriver().findElement(By.id("userId")).sendKeys(text);
    }

    @And("^user enters \"([0-9]*)\" on password$")
    public void setPasswordName(int value) {
        getDriver().findElement(By.id("passWd")).sendKeys("" + value);
    }

    @Then("^user wants to know the OS$")
    public void getOS() {
        System.out.println("OS is: " + OSDetector());
    }

    @DataTableType
    public Person definePerson(Map<String, String> entry) {
        return new Person(entry.get("name"), entry.get("position"), entry.get("office"));
    }

    // here the headers will be the first row
    /*@Then("^we verify following data exists$")
    public void dataVerification(List<List<String>> entry) {
        System.out.println(entry);
    }*/

    //
    @Then("^we verify following data exists$")
    public void dataVerification(List<Map<String, String>> entry) {
        for (Map<String, String> person : entry) {
            person.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
        }
    }

    static class Person {
        private String name;
        private String position;
        private String office;

        public Person(String name, String position, String office) {
            this.name = name;
            this.position = position;
            this.office = office;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

    }

    public static String OSDetector() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nux") || os.contains("nix")) {
            return "Linux";
        } else if (os.contains("mac")) {
            return "Mac";
        } else if (os.contains("sunos")) {
            return "Solaris";
        } else {
            return "Other";
        }
    }

    @Given("^user greeting$")
    public void user_greeting() {
        System.out.println("User Greeting step..");
    }

    @Then("^print member name \"([^\"]*)\"$")
    public void print_member_name(String arg1) {
        System.out.println("Member: " + arg1);
    }

    @Then("^print member location \"([^\"]*)\"$")
    public void print_member_location(String arg1) {
        System.out.println("Member Location: " + arg1);
    }

    @Given("^My name is \"([^\"]*)\"$")
    public void my_name_is(String arg1) {
        System.out.println("Name: " + arg1);
    }

    @Given("^I am (\\d+) years old$")
    public void i_am_years_old(int arg1) {
        System.out.println("Age: " + arg1);
    }

    @Given("^I have been to : \"(.+)\" for work$")
    public void i_have_been_to_Kolkata_Bhubaneswar_Pune_for_work(List<String> list) {
        System.out.println("Places I've been");
        list.forEach(System.out::println);
    }

    @Given("^the following datatable and convert to list$")
    public void the_following_datatable_and_convert_to_list(DataTable dataTable) {
        // raw(): Returns a List of List of String.
        /*List<List<String>> data = dataTable.raw();
        System.out.println(data.get(1).get(1));
        System.out.println(data);*/
    }

    @Given("^the following datatable and convert to map")
    public void the_following_datatable_and_convert_to_map(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("key is: " + entry.getKey() + " & Value is: ");
            System.out.println(entry.getValue());
        }
        System.out.println("==============================");
        map.forEach((a, b) -> System.out.println(a + ":" + b));
    }

    @Given("^the following datatable and convert to list automatically$")
    public void the_following_datatable_and_convert_to_list_automatically(List<List<String>> lists) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println(lists.get(1).get(1));
        System.out.println(lists.get(2).get(1));
        System.out.println("------------------------------------------------------------------------");
    }

}