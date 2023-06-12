package perosntest;

import com.rd.person.Man;
import com.rd.person.Person;
import com.rd.person.Woman;
import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DBReader;

public class ManTests {



    @Test(dataProvider = "propertiesLastNameDB", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManLastName(Man man, String lastname) {


        DBReader.getPropertiesFromDBById();

        Assert.assertEquals(man.getLastName(), lastname);

    }

    @Test(dataProvider = "propertiesAgeDB", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManAge(Man man, int expectedAge) {

        DBReader.getPropertiesFromDBById();

        Assert.assertEquals(man.getAge(), expectedAge,  "Age is not correct");

    }

    @Test(dataProvider = "propertiesFirstNameDB", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManFirstName(Man man, String firstname) {

        DBReader.getPropertiesFromDBById();

        String newName = DBReader.updateFirstname(1, "Brill");
        man.setFirstName(newName);

        Assert.assertEquals(man.getFirstName(), firstname);

    }


    @Test(dataProvider = "manIsRetireData", dataProviderClass = TestDataProvider.class)
    public void testisRetired(Man man, boolean expectedRetiredResult) {

        Assert.assertEquals(man.isRetired(), expectedRetiredResult, "Wrong retirement result");
    }

    @Test(dataProvider = "registerPartnershipMan", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(Man man, Woman woman, boolean expectedRegisteredResult) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.isRegisterPartnership(), expectedRegisteredResult, "Partnership was not registered");

    }
    @Test(dataProvider = "deRegisterPartnershipMan", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman, boolean expectedDeRegisteredResult) {

        man.deregisterPartnership(man.isRegisterPartnership());
        Assert.assertEquals(man.isRegisterPartnership(), false);

    }

//    @Test(dataProvider = "ManAge", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
//    public void testManAge(Man man, int expectedAge) {
//        Assert.assertEquals(man.getAge(), expectedAge,  "Age is not correct");
//
//    }

//    @Test(dataProvider = "ManLastName", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
//public void testManLastName(Man man, String  expectedLastName) {
//
////        DBReader.getPropertiesFromDB();
//
//    Assert.assertEquals(man.getLastName(), expectedLastName, "Lastname is not correct");
//
//}




//    @Test(dataProvider = "ManFirstName", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
////    public void testManFirstName(Man man, String expectedFirstName) {
////
////        DBReader.getPropertiesFromDB();
////
////        Assert.assertEquals(man.getFirstName(), expectedFirstName, "Firstname is not correct");
////
////    }

//
//    @Test(dataProvider = "ManFirstName", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
////    public void testManFirstName(Man man, String expectedFirstName) {
////
////        DBReader.getPropertiesFromDB();
////
////        Assert.assertEquals(man.getFirstName(), expectedFirstName, "Firstname is not correct");
////
////    }
    @Test(dataProvider = "ManHasNoPartner", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManHasNoPartner(Man man, Person expectedResult) {

        Assert.assertEquals(man.getPartner(), expectedResult);
    }

    @Test(dataProvider = "ManHasPartner", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void testManHasPartner(Man man, Woman woman, Person expectedResult) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner(), expectedResult);

    }

    @Test(dataProvider = "registerPartnershipMan", dataProviderClass = TestDataProvider.class, groups = {"ParametersTests"})
    public void isRegisterPartnership(Man man, Woman woman, boolean expectedRegisteredResult) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.isRegisterPartnership(), expectedRegisteredResult

        );
    }

}

