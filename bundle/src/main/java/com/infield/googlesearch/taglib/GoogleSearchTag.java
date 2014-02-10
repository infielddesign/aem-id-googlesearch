/*************************************************************************
 * Copyright 2014 Infield Design
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Gaetan Marmasse <gaetan@infielddesign.com>
 * 
 *************************************************************************/

package com.infield.googlesearch.taglib;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.jsp.JspException;

import org.apache.sling.api.scripting.SlingScriptHelper;
import org.osgi.service.component.ComponentContext;

import com.infield.googlesearch.GoogleSearchService;
import com.infield.googlesearch.model.ResultItem;
import com.infield.googlesearch.model.ResultList;


public class GoogleSearchTag extends SimpleTagSupport {

	private String q;
	private String currentTab;
	private long numberOfResults;
	private long numberOfPages;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		if (this.q.length() > 0 && this.currentTab.length() > 0 && this.numberOfResults > 0 && this.numberOfPages > 0){
			GoogleSearchService googleService = new GoogleSearchService();
			ResultList resultList = googleService.getResults(q, currentTab, numberOfResults, numberOfPages);
			LinkedList<ResultItem> resultItems = resultList.getResultItems();
			getJspContext().setAttribute("resultList",resultList);
			getJspContext().setAttribute("resultItems",resultItems);
		}
	}
	
	/**
	 * @return the q, the query
	 */
	public String getQ(){
		return q;
	}
	
	/**
	 * @param q the query to set
	 */
	public void setQ(String q){
		this.q = q;
	}
	
	/**
	 * @return the currentTab
	 */
	public String getCurrentTab(){
		return currentTab;
	}
	
	/**
	 * @param currentTab the currentTab to set
	 */
	public void setCurrentTab(String currentTab){
		this.currentTab = currentTab;
	}

	/**
	 * @return the numberOfResults
	 */
	public long getNumberOfResults() {
		return numberOfResults;
	}

	/**
	 * @param numberOfResults the numberOfResults to set
	 */
	public void setNumberOfResults(long numberOfResults) {
		this.numberOfResults = numberOfResults;
	}

	/**
	 * @return the numberOfPages
	 */
	public long getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
}
