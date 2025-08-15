class FrontMiddleBackQueue:
    class Node:
        def __init__(self, val):
            self.val = val
            self.next = None
            self.prev = None
    
    def __init__(self):
        self.head = self.Node(-1)  # dummy head
        self.tail = self.Node(-1)  # dummy tail
        self.head.next = self.tail
        self.tail.prev = self.head
        self.middle = None
        self.length = 0
    
    def pushFront(self, val):
        node = self.Node(val)
        node.next = self.head.next
        node.next.prev = node
        self.head.next = node
        node.prev = self.head
        self.length += 1
        
        if self.length == 1:
            self.middle = node
        elif self.length % 2 == 0:
            self.middle = self.middle.prev
    
    def pushMiddle(self, val):
        if self.length == 0:
            self.pushFront(val)
            return
        
        node = self.Node(val)
        
        if self.length % 2 == 1:
            node.next = self.middle
            node.prev = self.middle.prev
            self.middle.prev.next = node
            self.middle.prev = node
            self.middle = node
        else:
            node.next = self.middle.next
            self.middle.next.prev = node
            self.middle.next = node
            node.prev = self.middle
            self.middle = node
        
        self.length += 1
    
    def pushBack(self, val):
        node = self.Node(val)
        node.next = self.tail
        node.prev = self.tail.prev
        self.tail.prev.next = node
        self.tail.prev = node
        self.length += 1
        
        if self.length == 1:
            self.middle = node
        elif self.length % 2 == 1:
            self.middle = self.middle.next
    
    def popFront(self):
        if self.length == 0:
            return -1
        
        front_node = self.head.next
        self.head.next = front_node.next
        front_node.next.prev = self.head
        
        val = front_node.val
        self.length -= 1
        
        if self.length % 2 == 1:
            self.middle = self.middle.next
        if self.length == 0:
            self.middle = None
        
        return val
    
    def popMiddle(self):
        if self.length == 0:
            return -1
        
        if self.length % 2 == 1:
            new_middle = self.middle.prev
        else:
            new_middle = self.middle.next
        
        val = self.middle.val
        self.middle.prev.next = self.middle.next
        self.middle.next.prev = self.middle.prev
        
        self.length -= 1
        self.middle = new_middle
        
        if self.length == 0:
            self.middle = None
        
        return val
    
    def popBack(self):
        if self.length == 0:
            return -1
        
        back_node = self.tail.prev
        self.tail.prev = back_node.prev
        back_node.prev.next = self.tail
        
        val = back_node.val
        self.length -= 1
        
        if self.length % 2 == 0:
            self.middle = self.middle.prev
        if self.length == 0:
            self.middle = None
        
        return val
