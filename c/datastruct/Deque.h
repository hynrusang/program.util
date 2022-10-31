#ifndef DEQUEHEADER
/*
해당 헤더 파일은 동적 Deque 자료구조를 다루는 헤더 파일입니다.
작성자: 환류상.
*/
#define DEQUEHEADER
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "CustomType.h"
/*
단일 Deque 요소 하나를 다루는 Deque 구조체.
*/
typedef struct deque {
	element data;
	struct deque* before;
	struct deque* next;
}Deque;
/*
다중 Deque 요소를 다루는 DequeHeader 구조체.
*/
typedef struct dequeheader {
	Deque* first;
	Deque* last;
}DequeHeader;
/*
DequeHeader를 동적으로 초기화 시켜주는 함수.
ex) DequeHeader* header = init();
*/
DequeHeader* init() {
	DequeHeader* temp = (DequeHeader*)malloc(sizeof(DequeHeader));
	if (temp == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->first = (Deque*)malloc(sizeof(Deque));
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
해당 header가 비어있는 덱인지의 여부를 반환
ex) isEmpty(header : DequeHeader*);
*/
int isEmpty(DequeHeader* header) {
	return (header->first->next == 0);
}
/*
해당 data를 header의 앞에 in해주는 함수.
ex) inFront(header : DequeHeader*, 3);
*/
void inFront(DequeHeader* header, element data) {
	Deque* temp = (Deque*)malloc(sizeof(Deque));
	if (temp == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->data = data;
	temp->before = header->first;
	temp->next = header->first->next;
	header->first->next = temp;
	if (temp->next == 0) header->last = temp;
	else temp->next->before = temp;
}
/*
해당 data를 header의 뒤에 in해주는 함수.
ex) inBack(header : DequeHeader*, 3);
*/
void inBack(DequeHeader* header, element data) {
	Deque* temp = (Deque*)malloc(sizeof(Deque));
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
header의 처음 데이터를 out하고, 해당 값을 반환해주는 함수.
ex) outFront(header : DequeHeader*);
*/
element outFront(DequeHeader* header) {
	if (isEmpty(header)) {
		printf("The deque is empty.");
		exit(0);
	} else {
		Deque* trash = header->first->next;
		element temp = trash->data;
		trash->before->next = trash->next;
		trash->next->before = trash->before;
		free(trash);
		return temp;
	}
}
/*
header의 마지막 데이터를 out하고, 해당 값을 반환해주는 함수.
ex) outBack(header : DequeHeader*);
*/
element outBack(DequeHeader* header) {
	if (isEmpty(header)) {
		printf("The deque is empty.");
		exit(0);
	}
	else {
		Deque* trash = header->last;
		element temp = trash->data;
		trash->before->next = 0;
		header->last = trash->before;
		free(trash);
		return temp;
	}
}
/*
header의 처음 데이터를 반환해주는 함수.
ex) peekFront(header : DequeHeader*);
*/
element peekFront(DequeHeader* header) {
	if (isEmpty(header)) {
		printf("The deque is empty.");
		exit(0);
	}
	else return header->first->next->data;
}
/*
header의 마지막 데이터를 반환해주는 함수.
ex) peekFront(header : DequeHeader*);
*/
element peekBack(DequeHeader* header) {
	if (isEmpty(header)) {
		printf("The deque is empty.");
		exit(0);
	}
	else return header->last->data;
}
/*
header에 들어있는 모든 데이터를 차례대로 출력시켜주는 함수.
ex) prints(header : DequeHeader*);
*/
void prints(DequeHeader* header) {
	if (isEmpty(header)) {
		printf("The deque is empty.");
		exit(0);
	}
	else for (Deque* iterator = header->first->next; iterator != 0; iterator = iterator->next) printf(typeSelector, iterator->data);
	printf("\n");
}
#endif