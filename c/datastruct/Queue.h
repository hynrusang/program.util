#ifndef QUEUEHEADER
/*
해당 헤더 파일은 동적 Queue 자료구조를 다루는 헤더 파일입니다.
작성자: 환류상.
*/
#define QUEUEHEADER
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "CustomType.h"
/*
단일 Queue 요소 하나를 다루는 Queue 구조체.
*/
typedef struct queue {
	element data;
	struct queue* before;
	struct queue* next;
}Queue;
/*
다중 Queue 요소를 다루는 QueueHeader 구조체.
*/
typedef struct queueheader {
	Queue* first;
	Queue* last;
}QueueHeader;
/*
QueueHeader를 동적으로 초기화 시켜주는 함수.
ex) QueueHeader* header = init();
*/
QueueHeader* init() {
	QueueHeader* temp = (QueueHeader*)malloc(sizeof(QueueHeader));
	if (temp == 0) {
		printf("Dynamic memory allocation failed (may be due to low memory)");
		exit(0);
	}
	temp->first = (Queue*)malloc(sizeof(Queue));
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
해당 header가 비어있는 큐인지의 여부를 반환
ex) isEmpty(header : QueueHeader*);
*/
int isEmpty(QueueHeader* header) {
	return (header->first->next == 0);
}
/*
해당 data를 header에 put해주는 함수.
ex) put(header : QueueHeader*, 3);
*/
void put(QueueHeader* header, element data) {
	Queue* temp = (Queue*)malloc(sizeof(Queue));
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
header의 처음 데이터를 get하고, 해당 값을 반환해주는 함수.
ex) get(header : QueueHeader*);
*/
element get(QueueHeader* header) {
	if (isEmpty(header)) {
		printf("The queue is empty.");
		exit(0);
	} else {
		Queue* trash = header->first->next;
		element temp = trash->data;
		trash->before->next = trash->next;
		trash->next->before = trash->before;
		free(trash);
		return temp;
	}
}
/*
header의 처음 데이터를 반환해주는 함수.
ex) peek(header : QueueHeader*);
*/
element peek(QueueHeader* header) {
	if (isEmpty(header)) {
		printf("The queue is empty.");
		exit(0);
	}
	else return header->first->next->data;
}
/*
header에 들어있는 모든 데이터를 차례대로 출력시켜주는 함수.
ex) prints(header : QueueHeader*);
*/
void prints(QueueHeader* header) {
	if (isEmpty(header)) {
		printf("The queue is empty.");
		exit(0);
	}
	else for (Queue* iterator = header->first->next; iterator != 0; iterator = iterator->next) printf(typeSelector, iterator->data);
	printf("\n");
}
#endif