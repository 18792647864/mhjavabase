package com.manhuang.collection;

import java.util.ArrayList;
import java.util.List;

/*
 * 自己实现一个ArrayList，更好的去理解ArrayList类的底层结构
 */
public class SxtArrayList  /*implements  List*/{
	
	private Object[] elementData;
	
	private int size;
	
	public SxtArrayList(){
		this(10);
	}
	
	public SxtArrayList(int initialCapacity) {
		if(initialCapacity<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		elementData=new Object[initialCapacity];
	}
	
	
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	
	public void add(Object obj){
		ensureCapacity();
		elementData[size++]=obj;		//先赋值，然后size自增
	}
	
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void ensureCapacity(){
		//数组扩容和数据的拷贝
		if(size==elementData.length){
			Object[] newArray=new Object[size*2+2];
			//System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			for(int i=0;i<elementData.length;i++){
				newArray[i]=elementData[i];
			}
			elementData=newArray;
		}
	}
	public Object get(int index){
		rangeCheck(index);
		return elementData[index];
	}
	
	public void add(int index,Object obj){
		rangeCheck(index);
		//数组扩容和数据的拷贝
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index]=obj;
		size++;
		
	}
	
	
	 
	public Object set(int index ,Object obj){
		rangeCheck(index);
		Object oldValue=elementData[index];
		elementData[index]=obj;
		return oldValue;
	}
	
	public void remove(Object obj){
		for(int i=0;i<size;i++){
			if(get(i).equals(obj)){
				remove(i);
			}
		}
	}
	public void remove(int index){
		//删除指定位置的对象
		rangeCheck(index);
		int numMoved=size-index-1;
		if(numMoved>0){
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
			//自己试着实现这个数组Copy
		}
		elementData[--size]=null;
		
	}
	
	public static void main(String[] args){
		SxtArrayList list=new SxtArrayList(3);
		list.add("111");
		list.add("22222");
		list.add("45");
		list.add("ghjk");


		//test
		
		System.out.println(list.getSize());
		System.out.println(list.get(3));
		
	}

}
