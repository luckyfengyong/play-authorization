-- Create table
create table L_Zip_District_PhoneCode
(
  K_ID  VARCHAR(10)   not null,
  P_ID  VARCHAR(10)   not null,
  P_NM  VARCHAR(50)   not null,
  C_ID  VARCHAR(10)   not null,
  C_NM  VARCHAR(50)   not null,
  A_ID  VARCHAR(10)   not null,
  A_NM  VARCHAR(50)   not null,
  FULL_NAME VARCHAR(100)   not null,
  DISCTRICT_CODE  VARCHAR(10)  not null,
  ZIP_CODE  VARCHAR(10)   not null,
  PHONE_CODE VARCHAR(10)   not null
)
tablespace AMLTP
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 80
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column L_Zip_District_PhoneCode.K_ID
  is '����id';
comment on column L_Zip_District_PhoneCode.P_ID
  is 'ʡ��������';
comment on column L_Zip_District_PhoneCode.P_NM
  is 'ʡ����������';
comment on column L_Zip_District_PhoneCode.C_ID
  is '����������';
comment on column L_Zip_District_PhoneCode.C_NM
  is '������������';
comment on column L_Zip_District_PhoneCode.A_ID
  is '������������';
comment on column L_Zip_District_PhoneCode.A_NM
  is '��������������';
comment on column L_Zip_District_PhoneCode.FULL_NAME
  is '��������ȫ��';
comment on column L_Zip_District_PhoneCode.DISCTRICT_CODE
  is '�����������';
comment on column L_Zip_District_PhoneCode.ZIP_CODE
  is '����������������';
comment on column L_Zip_District_PhoneCode.PHONE_CODE
  is '�����������ű���';
-- Create/Recreate primary, unique and foreign key constraints 
alter table L_Zip_District_PhoneCode
  add constraint ZipCode_DistrictCode_PK primary key (K_ID)
  using index 
  tablespace AMLTP
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );