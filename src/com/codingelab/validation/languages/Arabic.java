/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.codingelab.validation.languages;

import com.codingelab.validation.errors.Error;
/**
 * @author Abdulrahman Abdulhamid Alsaedi
 * @since 1.0.1
 */
class Arabic implements Language{
	@Override
	public String getVariable() {
		return "";
	}
	
	@Override
	public String translate(Error error) {
		int number=error.getErrorNumber();
		switch (number) {
											/*Length Errors(from 0 to 255)*/
			case 1://Length not equal
				int num=(int)error.get();
				//����� 8 ����� ��� �����
				// ����� 8 �����
				// ����� 8 ����� ��� ������
				// ��� ������� ��� �� ���� ���� ������� �������: 5,10,20 
				// ��� ������� ��� �� ���� �� 5 ��� 10
				String temp="���� ���� �����";
				if(num==2)temp="���� ������ ������";
				else if(num>2)temp="���� "+num+" �����";
				return temp;
			case 2://Length below minimum limit
				int limit=(int)error.get();
				temp="���� ���� ����� ��� �����";
				if(limit==2)temp="���� ������ ������ ��� �����";
				else if(limit>2)temp="���� "+limit+" ����� ��� �����";
				return temp;
			case 3://Length above maximum limit
				limit=(int)error.get();
				temp="�� ���� ����� ���� �� ���� �����";
				if(limit==2)temp="�� ���� ����� ���� �� ������ ������";
				else if(limit>2)temp="�� ���� ����� ���� �� "+limit+" �����";
				return temp;
			case 4://length not between
				int [] between=(int [])error.get();
				return "��� ������� ��� �� ���� �� "+between[0]+" ��� "+between[1];
			case 5://length between
				between=(int [])error.get();
				return "��� ������� ��� ��� ���� �� "+between[0]+" ��� "+between[1];
			case 6://length not equal to one of
				int [] allLengths=(int [])error.get();
				int first=allLengths[0];
				if(allLengths.length==1){
					temp="���� ���� �����";
					if(first==2)temp="���� ������ ������";
					else if(first>2)temp="���� "+first+" �����";
					return temp;
				}else{
					temp="��� ������� ��� �� ���� ���� ������� �������: "+first;
					for(int i=1;i<allLengths.length;i++)
						temp+=" �� "+allLengths[i];
				}
				return temp;
				/*if(allLengths.length==2)
					numbers+=" or "+allLengths[1];
				else if(allLengths.length>2){
					for(int i=1;i<allLengths.length-1;i++)
						numbers+=", "+allLengths[i];
					numbers+=" or "+allLengths[allLengths.length-1];
				}
				if(allLengths.length==1)
					return getVariable()+" length must be equal to "+numbers;
				return getVariable()+" length must be equal to one of this lengths: "+numbers;*/
				
											/*Main Errors(from 256 to 1024)*/
			case 256://Empty input           ����
				return "�� ����� ��� ������ �����";
			case 257://Has letters
				return "�� ����� ����� ������";
			case 258://Has letters in range
				String range=(String)error.get();
				return "�� ����� ����� ������ �������: "+range;
			case 259://Has letters out range
				range=(String)error.get();
				return "����� ����� ������ ������� ���: "+range;
			case 260://Required more letters
				num=(int)error.get();
				if(num<=1)temp="��� ����� ��� ���� ��� �����";
				else if(num==2)temp="��� ����� ����� ����� ��� �����";
				else temp="��� ����� "+num+" ���� ��� �����";
				return temp;
			case 261://Has numbers
				return getVariable()+"�� ����� ����� �������";
			case 262://Has numbers in range
				range=(String)error.get();
				return "�� ����� ����� ������� �������: "+range;
			case 263://Has numbers out range
				range=(String)error.get();
				return "����� ����� ������� ������� ���: "+range;
			case 264://Required more numbers
				num=(int)error.get();
				if(num<=1)temp="��� ����� ��� ���� ��� �����";
				else if(num==2)temp="��� ����� ����� ����� ��� �����";
				else temp="��� ����� "+num+" ����� ��� �����";
				return temp;
			case 265://Has special characters
				return "�� ����� ����� ������";
			case 266://Has special characters in range
				range=(String)error.get();
				return "�� ����� ����� ������ �������: "+range;
			case 267://Has special characters out range
				range=(String)error.get();
				return "����� ����� ������ ������� ���: "+range;
			case 268://Required more special characters
				num=(int)error.get();
				if(num<=1)temp="��� ����� ��� ��� ���� ��� �����";
				else if(num==2)temp="��� ����� ����� ����� ����� ��� �����";
				else temp="��� ����� "+num+" ���� ���� ��� �����";
				return temp;
			case 269://Has white spaces
				return "�� ����� ����� �������� ";
			case 270://Has white spaces out range 
				return "�� ����� ����� �������� �������: "+"Tab/Enter";
				
				
				
				
			case 301:return "����� ������ ���������� ��� ����"; 
			case 302:return "���� ����� ������ ���������� ���� �� ���";
			case 303:return "����� �� ����� ���� �������� ��� ��� ��� ����� \"@\"";
			case 304:return "�� ����� ��� ������ ���������� ����� (��� ����� \"@\") ";
			case 305:return "�� ����� ����� ������ ���������� ��� ���� �������";
			case 306:return "����� �� ����� ���� �������� ��� ����� \"@\" ";
			case 307:return "����� �� ����� ���� �������� ��� ����� \"@\" ����� ���";
			case 308:return "����� �� ����� ���� �������� ��� ��� ���� ��� \"gmail@\"";
			case 309:return "����� ��� ������ �� ���� ������ ��� ��� \"gmail@\"";
			case 310:return "����� �� ����� ���� �������� ��� \"TLD\" ��� \"com.\"";
			/*// For top level domain
			case 311:return "TLD ����� �� ���� ������ ������ ��� ����� ��� \"com.\"";
			// For sub-level domain
			case 312:return "SLD ����� �� ���� ������ ������ ��� ����� ��� \"com.sa.\"";
			*/
			case 313:return "TLD �� SLD ��� ����. ������ ������ ������ ������� \"com.sa.\"";
		}
		return "";
	}
 
}
