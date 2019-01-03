package com.zhaolongefu.librarian.entity;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.zhaolongefu.librarian.util.ConstantUtil;


/**
 * 系统分页对象类
 * 本类封装了：当前页码-pageNum，每页显示数量-pageSize，dataTables组件确定信息-draw
 * 分页列表-list，总数量-totalCount和总页数-totalNum
 * @author MailLang
 * @version 0.0.1-SNAPSHOT 2018-11-13
 */
public class WinPage<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;
	private Integer pageSize;
	private Integer draw;
	private List<E> list;
	private Long totalCount;
	private Long totalNum;
	
	public WinPage() {}
	public WinPage(Integer pageNum, Integer pageSize) {
		// 判断所给定的pageNum是否合法
		if (pageNum != null && pageNum > 0) {
			// 分页对象合法，那么使用该值
			this.pageNum = pageNum;
		} else {
			// 否则使用默认值
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		
		// 判断所给定的pageNum是否合法
		if (pageSize != null && pageSize > 0) {
			// 分页对象合法，那么使用该值
			this.pageSize = pageSize;
		} else {
			// 否则使用默认值
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}
	public WinPage(Integer pageNum, Integer pageSize, Integer draw) {
		// 判断所给定的pageNum是否合法
		if (pageNum != null && pageNum > 0) {
			// 分页对象合法，那么使用该值
			this.pageNum = pageNum;
		} else {
			// 否则使用默认值
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		
		// 判断所给定的pageNum是否合法
		if (pageSize != null && pageSize > 0) {
			// 分页对象合法，那么使用该值
			this.pageSize = pageSize;
		} else {
			// 否则使用默认值
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
		
		this.draw = draw;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
	
	/**
	 ** 将JPA所提供的分页对象信息转换到WinMallPage中 
	 * @param winMallPage
	 * @param page
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void parsePageToWinPage(Page page) {
		this.setList(page.getContent());
		this.setTotalCount(page.getTotalElements());
		this.setTotalNum((long) page.getTotalPages());
	}
}
