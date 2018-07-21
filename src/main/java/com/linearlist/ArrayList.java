package com.linearlist;

import java.util.Arrays;

public class ArrayList {
	private Object[] array;

	public ArrayList(int initSize) {
		array = new Object[initSize];
	}

	public void print() {
		int size = size();
		StringBuffer str= new StringBuffer();
		for(int i = 0;i<size;i++){
			str.append(array[i]+" ");
		}
		System.out.println(str);
	}

	public int size() {
		int i =0;
		if(array==null){		
		}else{
			if(array[array.length-1]!=null){
				return array.length;
			}
			while(array[i]!=null){
				i++;
			}
		}
		return i;
	}

	public void add(Object obj,int index) throws Exception{
		if(index<0||index>size()){
			System.out.println("adding error!");
		}else if(array.length==size()){
			array=increaseArraySize(1,array);
			if(index==array.length-1){
				array[index]=obj;
			}else{
				backMove(index);
				array[index]=obj;
			}
		}else{
			if(index==size()){
				array[index]=obj;
			}else{
				backMove(index);
				array[index]=obj;
			}
		}
	}
	
	public void delete(int index){
		if(index<0||index>=size()){
			System.out.println("delete error");
		}else{
			if(index==size()-1){
				array[index]=null;
			}else{
				frontMove(index);
				array[size()-1]=null;
			}
		}
	}
	
	private void backMove(int index){
		for(int i = size();i>index;i--){
			array[i]=array[i-1];
		}		
	}
	
	private void frontMove(int index){
		for(int i = index;i<size()-1;i++){
			array[i]=array[i+1];
		}		
	}

	private Object[] increaseArraySize(int size, Object[] srcArray) {
		Object[] newArray = new Object[srcArray.length + size];
		System.arraycopy(srcArray, 0, newArray, 0, srcArray.length);
		return newArray;
	}

}
