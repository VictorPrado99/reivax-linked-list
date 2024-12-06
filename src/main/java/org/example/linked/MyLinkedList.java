package org.example.linked;

/*Task: Implement a linked list of Integers, with the following operations:

        - add an element to the list (at the end)
        - remove an element from the list (by index)
        - Find the highest element on the list, returning the value and the index
        - Print the number of occurrences of each element on the list*/

public class MyLinkedList implements LinkedList {

    private Element head;
    private Element tail;

    @Override
    public void add(int number) {
        Element element = new Element(number);

        if (head == null){
            head = element;
            tail = element;
            return;
        }

        tail.setNextIndex(element);
        tail = element;
    }

    @Override
    public void remove(int index) {
        if(head == null || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index == 0){
            if(head.nextIndex == null){
                tail = null;
            }
            head = head.nextIndex;
            return;
        }

        var element = head;
        for (int i = 0; i < index ; i++) {
            element = element.getNextIndex();
            if (element == null){
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        var removedElement = element.getNextIndex();

        if (removedElement == null){
            throw new ArrayIndexOutOfBoundsException();
        }

        element.setNextIndex(removedElement.getNextIndex());
    }

    private class Element {

        private final int value;
        private Element nextIndex;

        public Element(int value) {
            this.value = value;
        }

        public void setNextIndex(Element nextIndex) {
            this.nextIndex = nextIndex;
        }

        public Element getNextIndex() {
            return nextIndex;
        }
    }

}