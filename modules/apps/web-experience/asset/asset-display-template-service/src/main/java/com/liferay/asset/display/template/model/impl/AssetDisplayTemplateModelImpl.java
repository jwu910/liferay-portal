/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.display.template.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.display.template.model.AssetDisplayTemplate;
import com.liferay.asset.display.template.model.AssetDisplayTemplateModel;
import com.liferay.asset.display.template.model.AssetDisplayTemplateSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AssetDisplayTemplate service. Represents a row in the &quot;AssetDisplayTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AssetDisplayTemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetDisplayTemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetDisplayTemplateImpl
 * @see AssetDisplayTemplate
 * @see AssetDisplayTemplateModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AssetDisplayTemplateModelImpl extends BaseModelImpl<AssetDisplayTemplate>
	implements AssetDisplayTemplateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset display template model instance should use the {@link AssetDisplayTemplate} interface instead.
	 */
	public static final String TABLE_NAME = "AssetDisplayTemplate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "assetDisplayTemplateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "classNameId", Types.BIGINT },
			{ "DDMTemplateId", Types.BIGINT },
			{ "main", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("assetDisplayTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DDMTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("main", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table AssetDisplayTemplate (assetDisplayTemplateId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,classNameId LONG,DDMTemplateId LONG,main BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table AssetDisplayTemplate";
	public static final String ORDER_BY_JPQL = " ORDER BY assetDisplayTemplate.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY AssetDisplayTemplate.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.asset.display.template.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.asset.display.template.model.AssetDisplayTemplate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.asset.display.template.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.asset.display.template.model.AssetDisplayTemplate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.asset.display.template.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.asset.display.template.model.AssetDisplayTemplate"),
			true);
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long NAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AssetDisplayTemplate toModel(
		AssetDisplayTemplateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AssetDisplayTemplate model = new AssetDisplayTemplateImpl();

		model.setAssetDisplayTemplateId(soapModel.getAssetDisplayTemplateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setClassNameId(soapModel.getClassNameId());
		model.setDDMTemplateId(soapModel.getDDMTemplateId());
		model.setMain(soapModel.getMain());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AssetDisplayTemplate> toModels(
		AssetDisplayTemplateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AssetDisplayTemplate> models = new ArrayList<AssetDisplayTemplate>(soapModels.length);

		for (AssetDisplayTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.asset.display.template.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.asset.display.template.model.AssetDisplayTemplate"));

	public AssetDisplayTemplateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _assetDisplayTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssetDisplayTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assetDisplayTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetDisplayTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return AssetDisplayTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assetDisplayTemplateId", getAssetDisplayTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("classNameId", getClassNameId());
		attributes.put("DDMTemplateId", getDDMTemplateId());
		attributes.put("main", getMain());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long assetDisplayTemplateId = (Long)attributes.get(
				"assetDisplayTemplateId");

		if (assetDisplayTemplateId != null) {
			setAssetDisplayTemplateId(assetDisplayTemplateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long DDMTemplateId = (Long)attributes.get("DDMTemplateId");

		if (DDMTemplateId != null) {
			setDDMTemplateId(DDMTemplateId);
		}

		Boolean main = (Boolean)attributes.get("main");

		if (main != null) {
			setMain(main);
		}
	}

	@JSON
	@Override
	public long getAssetDisplayTemplateId() {
		return _assetDisplayTemplateId;
	}

	@Override
	public void setAssetDisplayTemplateId(long assetDisplayTemplateId) {
		_assetDisplayTemplateId = assetDisplayTemplateId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getDDMTemplateId() {
		return _DDMTemplateId;
	}

	@Override
	public void setDDMTemplateId(long DDMTemplateId) {
		_DDMTemplateId = DDMTemplateId;
	}

	@JSON
	@Override
	public boolean getMain() {
		return _main;
	}

	@JSON
	@Override
	public boolean isMain() {
		return _main;
	}

	@Override
	public void setMain(boolean main) {
		_main = main;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AssetDisplayTemplate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetDisplayTemplate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AssetDisplayTemplate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssetDisplayTemplateImpl assetDisplayTemplateImpl = new AssetDisplayTemplateImpl();

		assetDisplayTemplateImpl.setAssetDisplayTemplateId(getAssetDisplayTemplateId());
		assetDisplayTemplateImpl.setGroupId(getGroupId());
		assetDisplayTemplateImpl.setCompanyId(getCompanyId());
		assetDisplayTemplateImpl.setUserId(getUserId());
		assetDisplayTemplateImpl.setUserName(getUserName());
		assetDisplayTemplateImpl.setCreateDate(getCreateDate());
		assetDisplayTemplateImpl.setModifiedDate(getModifiedDate());
		assetDisplayTemplateImpl.setName(getName());
		assetDisplayTemplateImpl.setClassNameId(getClassNameId());
		assetDisplayTemplateImpl.setDDMTemplateId(getDDMTemplateId());
		assetDisplayTemplateImpl.setMain(getMain());

		assetDisplayTemplateImpl.resetOriginalValues();

		return assetDisplayTemplateImpl;
	}

	@Override
	public int compareTo(AssetDisplayTemplate assetDisplayTemplate) {
		int value = 0;

		value = getName().compareTo(assetDisplayTemplate.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetDisplayTemplate)) {
			return false;
		}

		AssetDisplayTemplate assetDisplayTemplate = (AssetDisplayTemplate)obj;

		long primaryKey = assetDisplayTemplate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		AssetDisplayTemplateModelImpl assetDisplayTemplateModelImpl = this;

		assetDisplayTemplateModelImpl._originalGroupId = assetDisplayTemplateModelImpl._groupId;

		assetDisplayTemplateModelImpl._setOriginalGroupId = false;

		assetDisplayTemplateModelImpl._setModifiedDate = false;

		assetDisplayTemplateModelImpl._originalClassNameId = assetDisplayTemplateModelImpl._classNameId;

		assetDisplayTemplateModelImpl._setOriginalClassNameId = false;

		assetDisplayTemplateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetDisplayTemplate> toCacheModel() {
		AssetDisplayTemplateCacheModel assetDisplayTemplateCacheModel = new AssetDisplayTemplateCacheModel();

		assetDisplayTemplateCacheModel.assetDisplayTemplateId = getAssetDisplayTemplateId();

		assetDisplayTemplateCacheModel.groupId = getGroupId();

		assetDisplayTemplateCacheModel.companyId = getCompanyId();

		assetDisplayTemplateCacheModel.userId = getUserId();

		assetDisplayTemplateCacheModel.userName = getUserName();

		String userName = assetDisplayTemplateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			assetDisplayTemplateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			assetDisplayTemplateCacheModel.createDate = createDate.getTime();
		}
		else {
			assetDisplayTemplateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			assetDisplayTemplateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			assetDisplayTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		assetDisplayTemplateCacheModel.name = getName();

		String name = assetDisplayTemplateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			assetDisplayTemplateCacheModel.name = null;
		}

		assetDisplayTemplateCacheModel.classNameId = getClassNameId();

		assetDisplayTemplateCacheModel.DDMTemplateId = getDDMTemplateId();

		assetDisplayTemplateCacheModel.main = getMain();

		return assetDisplayTemplateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{assetDisplayTemplateId=");
		sb.append(getAssetDisplayTemplateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", DDMTemplateId=");
		sb.append(getDDMTemplateId());
		sb.append(", main=");
		sb.append(getMain());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.asset.display.template.model.AssetDisplayTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>assetDisplayTemplateId</column-name><column-value><![CDATA[");
		sb.append(getAssetDisplayTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DDMTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDDMTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>main</column-name><column-value><![CDATA[");
		sb.append(getMain());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AssetDisplayTemplate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AssetDisplayTemplate.class
		};
	private long _assetDisplayTemplateId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _DDMTemplateId;
	private boolean _main;
	private long _columnBitmask;
	private AssetDisplayTemplate _escapedModel;
}