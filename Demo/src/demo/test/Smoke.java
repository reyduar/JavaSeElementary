package demo.test;

import it.sauronsoftware.jave.Video;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.globant.app.core.GlobDriver;
import com.globant.app.core.data.factory.XmlDataFactory;
import demo.page.WikiArticlePage;
import demo.page.WikiHomePage;

public class Smoke {
	
	Video currentVideo;
	
	@DataProvider(name = "searchCriterias")
	public Object[][] searchCriterias() throws IOException {
		XmlDataFactory xmlFactory = XmlDataFactory.getInstance();
		xmlFactory.initialize("./src/demo/data/");
		return xmlFactory.getArrayFromDataSet("WikiSearch");
	}
	
	@BeforeSuite
	public void BeforeSuite(ITestContext context){
		GlobDriver.getInstance().tearUp(context);
	}
	
	@AfterSuite
	public void afterSuite(){
		GlobDriver.getInstance().tearDown();
	}
	
	@Test
	public void enterEnglishWiki(){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		home.clickLinkEnglish();
		Assert.assertEquals(home.getPageTitle(), "Wikipedia, the free encyclopedia");
	}
	
	@Test
	public void randomArticleWorks(){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		WikiArticlePage articlePage = home.clickLinkEnglish();
		articlePage.clickRandomArticle();
		String firstArticleTitle = articlePage.getArticleTitle();
		articlePage =  articlePage.clickRandomArticle();
		Assert.assertNotEquals(articlePage.getArticleTitle(), firstArticleTitle);
				
	}
	
	@Test
	public void screenshot(){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		home.takeScreenshot("screenshot.jpg", "./target/surefire-reports/screenshots/");
		Assert.assertEquals(home.getPageTitle(),"Wikipedia");
	}
	
	@Test
	public void pageSource(){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		String source = home.getPageSource();
		Assert.assertTrue(source.contains("html"));
	}
	
	@Test
	public void pageUrl(){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		String url = home.getCurrentUrl();
		Assert.assertTrue(url.contains("wikipedia.org"));
	}
	
	@Test(dataProvider="searchCriterias")
	public void search(String search,String expected){
		WikiHomePage home = PageFactory.initElements(GlobDriver.getInstance().getDriver(), WikiHomePage.class);
		home.go();
		WikiArticlePage articlePage = home.clickLinkEnglish();
		articlePage.searchFor(search);
		Assert.assertEquals(articlePage.getArticleTitle(), expected);
	}
	
}
