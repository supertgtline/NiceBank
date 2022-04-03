package nicebank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import support.KnowsTheDomain;
import transforms.MoneyConverter;
import cucumber.api.Transform;

public class AccountSteps {
    KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(
            @Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        helper.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(
            @Transform(MoneyConverter.class) Money amount)
            throws Throwable {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }
}