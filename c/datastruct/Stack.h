#ifndef STACKHEADER
/*
해당 헤더 파일은 동적 Stack 자료구조를 다루는 헤더 파일입니다.
작성자: 환류상.
*/
#define STACKHEADER
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "CustomType.h"
/*
단일 Stack 요소 하나를 다루는 Stack 구조체.
*/
typedef struct stack {
	element data;
	struct stack* before;
	struct stack* next;
}Stack;
/*
다중 Stack 요소를 다루는 StackHeader 구조체.
*/
typedef struct stackheader {
	Stack* first;
	Stack* last;
}StackHeader;
/*
StackHeader를 동적으로 초기화 시켜주는 함수.
ex) StackHeader* header = init();
*/
StackHeader* init() {
	StackHeader* temp = (StackHeader*)malloc(sizeof(StackHeader));
	if (temp == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->first = (Stack*)malloc(sizeof(Stack));
	if (temp->first == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->first->data = 0;
	temp->first->before = 0;
	temp->first->next = 0;
	temp->last = 0;
	return temp;
}
/*
해당 header가 비어있는 스택인지의 여부를 반환
ex) isEmpty(header : StackHeader*);
*/
int isEmpty(StackHeader* header) {
	return (header->first->next == 0);
}
/*
해당 data를 header에 push해주는 함수.
ex) push(header : StackHeader*, 3);
*/
void push(StackHeader* header, element data) {
	Stack* temp = (Stack*)malloc(sizeof(Stack));
	if (temp == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->data = data;
	if (isEmpty(header)) temp->before = header->first;
	else temp->before = header->last;
	temp->before->next = temp;
	temp->next = 0;
	header->last = temp;
}
/*
header의 마지막 데이터를 pop하고, 해당 값을 반환해주는 함수.
ex) pop(header : StackHeader*);
*/
element pop(StackHeader* header) {
	if (isEmpty(header)) {
		printf("The stack is empty.");
		exit(0);
	} else {
		Stack* trash = header->last;
		element temp = trash->data;
		trash->before->next = 0;
		header->last = trash->before;
		free(trash);
		return temp;
	}
}
/*
header의 마지막 데이터를 반환해주는 함수.
ex) peek(header : StackHeader*);
*/
element peek(StackHeader* header) {
	if (isEmpty(header)) {
		printf("The stack is empty.");
		exit(0);
	} else return header->last->data;
}
/*
header에 들어있는 모든 데이터를 차례대로 출력시켜주는 함수.
ex) prints(header : StackHeader*);
*/
void prints(StackHeader* header) {
	if (isEmpty(header)) {
		printf("The stack is empty.");
		exit(0);
	} else for (Stack* iterator = header->first->next; iterator != 0; iterator = iterator->next) printf(typeSelector, iterator->data);
	printf("\n");
}
#endif