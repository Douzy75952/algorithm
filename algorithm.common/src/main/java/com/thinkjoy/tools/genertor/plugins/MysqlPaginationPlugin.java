package com.thinkjoy.tools.genertor.plugins;

import com.thinkjoy.tools.genertor.genertor.VelocityMain;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class MysqlPaginationPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		// 声明selectpagelist分页方法
		Method method = new Method("selectPageList");
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.Map"));

		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
		Parameter parameter = new Parameter(new FullyQualifiedJavaType(
				"java.util.Map"), "map");
		method.addParameter(parameter);
		method.setReturnType(new FullyQualifiedJavaType("java.util.List<"
				+ introspectedTable.getFullyQualifiedTable()
						.getDomainObjectName() + ">"));

		// 声明selectlist方法
		Method listMethod = new Method("selectList");
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.Map"));
		Parameter listParameter = new Parameter(new FullyQualifiedJavaType(
				"java.util.Map"), "map");
		listMethod.addParameter(listParameter);
		listMethod.setReturnType(new FullyQualifiedJavaType("java.util.List<"
				+ introspectedTable.getFullyQualifiedTable()
						.getDomainObjectName() + ">"));
		
		// 声明selectlist方法
		Method modelMethod = new Method("selectModel");
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.Map"));
		Parameter modelParameter = new Parameter(new FullyQualifiedJavaType(
				"java.util.Map"), "map");
		modelMethod.addParameter(modelParameter);
		modelMethod.setReturnType(new FullyQualifiedJavaType("java.util.List<"
				+ introspectedTable.getFullyQualifiedTable()
						.getDomainObjectName() + ">"));

		//selectcount
		Method countMethod = new Method("selectCount");
		interfaze.addImportedType(new FullyQualifiedJavaType("java.util.Map"));

	
		Parameter countParameter = new Parameter(new FullyQualifiedJavaType(
				"java.util.Map"), "map");
		countMethod.addParameter(countParameter);
		countMethod.setReturnType(new FullyQualifiedJavaType("int"));
		
	
		interfaze.addMethod(method);
		interfaze.addMethod(modelMethod);
		interfaze.addMethod(listMethod);
		interfaze.addMethod(countMethod);

		return super.clientGenerated(interfaze, topLevelClass,
				introspectedTable);
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		// 产生selectList语句
		XmlElement selectListElement = new XmlElement("select");
		selectListElement.addAttribute(new Attribute("id", "selectList"));
		selectListElement.addAttribute(new Attribute("resultMap",
				"BaseResultMap")); 
		
		selectListElement.addAttribute(new Attribute("parameterType",
				"java.util.Map"));

		// <include refid="Base_Column_List" />

		TextElement basePrefixSelect = new TextElement("select ");
		XmlElement Base_Column_List = new XmlElement("include");
		Base_Column_List
				.addAttribute(new Attribute("refid", "Base_Column_List"));

		TextElement basePrefixfrom = new TextElement(" from ");

		selectListElement.addElement(basePrefixSelect);
		selectListElement.addElement(Base_Column_List);
		selectListElement.addElement(basePrefixfrom);

		
	
		// XmlElement pageStart = new XmlElement("if");
		// pageStart.addAttribute(new Attribute("test", "page != null"));
		// pageStart.addElement(new TextElement(
		// "(select row_.*, rownumber()over(order by pos_typ_id) as rowid from "));
		// paginationPrefixElement.addElement(pageStart);
		TextElement qualifiedTableName = new TextElement(" "
				+ introspectedTable.getTableConfiguration().getSchema() + "."
				+ introspectedTable.getTableConfiguration().getTableName());

		selectListElement.addElement(qualifiedTableName);

		selectListElement
				.addElement(getListIntrospectedColumn(introspectedTable));
		
		XmlElement order = new XmlElement("if");
		order.addAttribute(new Attribute("test", "order != null"));
		order.addElement(new TextElement(
				"<![CDATA[  order by  ${order} ]]>"));
		selectListElement.addElement(order);
		
		
		// 产生selectModel语句
		XmlElement selectModelElement = new XmlElement("select");
		selectModelElement.addAttribute(new Attribute("id", "selectModel"));
		selectModelElement.addAttribute(new Attribute("resultMap",
				"BaseResultMap")); 
		
		selectModelElement.addAttribute(new Attribute("parameterType",
				"java.util.Map"));

		selectModelElement.addElement(basePrefixSelect);
		selectModelElement.addElement(Base_Column_List);
		selectModelElement.addElement(basePrefixfrom);
		selectModelElement.addElement(qualifiedTableName);
		selectModelElement.addElement(getListIntrospectedColumn(introspectedTable));
		selectModelElement.addElement(order);
		/*
		 * <if test="scoreCd != null" > #{scoreCd,jdbcType=VARCHAR}, <trim
		 * prefix="values (" suffix=")" suffixOverrides="," >
		 */
		// XmlElement pagelistEnd = new XmlElement("if");
		// pagelistEnd.addAttribute(new Attribute("test", "page != null"));
		// pagelistEnd.addElement(new TextElement(
		// "<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <= #{page.end} ]]>"));
		// paginationPrefixElement.addElement(pagelistEnd);
		// parentElement.addElement(paginationPrefixElement);

		// 产生分页语句后半部分
		// XmlElement paginationSuffixElement = new XmlElement("select");
		// paginationSuffixElement.addAttribute(new Attribute("id",
		// "selectPageList"));
		// XmlElement pageEnd = new XmlElement("if");
		// pageEnd.addAttribute(new Attribute("test", "page != null"));
		// pageEnd.addElement(new TextElement(
		// "<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and rownum_ <= #{page.end} ]]>"));
		// paginationSuffixElement.addElement(pageEnd);
		// 产生selectPageList语句
		XmlElement selectPageListElement = new XmlElement("select");

		selectPageListElement
				.addAttribute(new Attribute("id", "selectPageList"));
		selectPageListElement.addAttribute(new Attribute("resultMap",
				"BaseResultMap"));
		selectPageListElement.addAttribute(new Attribute("parameterType",
				"java.util.Map"));

		selectPageListElement.addElement(basePrefixSelect);
		selectPageListElement.addElement(Base_Column_List);

		selectPageListElement.addElement(new TextElement(" from "));
		selectPageListElement.addElement(qualifiedTableName);

		selectPageListElement
				.addElement(getListIntrospectedColumn(introspectedTable));

		XmlElement pageListSuffixEnd = new XmlElement("if");
		pageListSuffixEnd.addAttribute(new Attribute("test", "page != null"));
		pageListSuffixEnd.addElement(new TextElement(
				"<![CDATA[  limit #{page.begin}, #{page.end} ]]>"));

	
		selectPageListElement.addElement(order);
		selectPageListElement.addElement(pageListSuffixEnd);
		
		
		// 产生selectcount语句
		XmlElement selectCountElement = new XmlElement("select");
		selectCountElement.addElement(new TextElement(" select"));
		selectCountElement.addAttribute(new Attribute("id", "selectCount"));
		
		selectCountElement.addAttribute(new Attribute("resultType",
				"int"));
		selectCountElement.addAttribute(new Attribute("parameterType",
				"java.util.Map"));
		selectCountElement.addElement(new TextElement(" count(1)"));
		selectCountElement.addElement(new TextElement(" from "));
		selectCountElement.addElement(qualifiedTableName);

		selectCountElement
				.addElement(getListIntrospectedColumn(introspectedTable));
		
		// 添加元素
		parentElement.addElement(selectModelElement);
		parentElement.addElement(selectListElement);
		parentElement.addElement(selectPageListElement);
		parentElement.addElement(selectCountElement);
		final String domainObjectName = introspectedTable
				.getFullyQualifiedTable().getDomainObjectName();
		
		String parameterType;
		if (introspectedTable.getRules().generatePrimaryKeyClass()) {
			parameterType = introspectedTable.getPrimaryKeyType();
		} else {
			// PK fields are in the base class. If more than on PK
			// field, then they are coming in a map.
			if (introspectedTable.getPrimaryKeyColumns().size() > 1) {
				parameterType = "map"; //$NON-NLS-1$
			} else {
				parameterType = introspectedTable.getPrimaryKeyColumns().get(0)
						.getFullyQualifiedJavaType().toString();
			}
		}

		final String PK = parameterType;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VelocityMain().genertor(domainObjectName, PK);

			}
		}).start();

		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	public XmlElement getListIntrospectedColumn(
			IntrospectedTable introspectedTable) {
		XmlElement whereFilterElement = new XmlElement("where");
		List<IntrospectedColumn> columnsList = introspectedTable
				.getAllColumns();
		for (IntrospectedColumn column : columnsList) {
			XmlElement columsFilterElement = new XmlElement("if");
			columsFilterElement.addAttribute(new Attribute("test", column
					.getJavaProperty() + " != null"));
			// #{businessid,jdbcType=VARCHAR},
			columsFilterElement.addElement(new TextElement(" and "
					+ column.getActualColumnName() + "= #{"
					+ column.getJavaProperty() + ",jdbcType="+ column.getJdbcTypeName()+"}"));
			//,jdbcType="+ column.getJdbcTypeName() + 
			whereFilterElement.addElement(columsFilterElement);
		}
		return whereFilterElement;

	}

}
