package com.testng;

public class excelPOI {
	
	public static String html = "<input class=\"ais-SearchBox-input\" id=\"doc-search-box-input\" name=\"query\" type=\"search\" placeholder=\"Search across browserstack.com\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" maxlength=\"512\" autofocus aria-label=\"Search across browserstack.com\">\r\n"
			+ "<input type=\"hidden\" value=\"all\" name=\"type\">\r\n"
			+ "<input autocomplete=\"off\" class=\"text input-lg input-primary input-margin\" id=\"live-form-url\" name=\"url\" placeholder=\"www.website.com\" type=\"text\" aria-label=\"Type URL\" aria-required=\"true\">\r\n"
			+ "<input id=\"live-form-submit-btn\" class=\"btn-lg btn-primary\" data-btndisabled=\"Validating...\" data-btntext=\"Start test\" type=\"submit\" value=\"Start test\" role=\"button\">\r\n"
			+ "<input autocomplete=\"off\" class=\"text input-lg input-primary input-margin\" id=\"live-local-testing-url\" name=\"url\" placeholder=\"www.website.com\" type=\"text\" aria-label=\"Type URL\" aria-required=\"true\">\r\n"
			+ "<input id=\"live-local-testing-submit-btn\" class=\"live-local-testing-form__btnholder-btn btn-lg btn-primary\" data-btndisabled=\"Validating...\" data-btntext=\"Start test\" type=\"submit\" value=\"Start test\" role=\"button\">";

	public static void main(String ar[]) {
	String htmlsplit[] = html.split("<input ");
	
	for(int i=0;i<htmlsplit.length;i++)
	{
		System.out.println("<input "+htmlsplit[i]);
		String htmlsplit2[] = htmlsplit[i].split(" ");
		for(int ii=0;ii<htmlsplit2.length;ii++)
		{
			System.out.print(" "+htmlsplit2[ii]);
		}
	}
	}
}
