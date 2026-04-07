class Item:
    def __init__(self, key, value):
        self.key = key
        self.value = value


class PriorityQueue(object):
    def __init__(self):
        self.nodes : list[Item] = [Item(None , None)]
        self.counter = 0

    def _heapify(self , new_node_idx):
        while 1 < new_node_idx:
            new_node = self.nodes[new_node_idx]
            parent_idx = new_node_idx // 2
            parent_node = self.nodes[parent_idx]

            if parent_node.key >= new_node.key:
                break

            self.nodes[new_node_idx], self.nodes[parent_idx] = self.nodes[parent_idx], self.nodes[new_node_idx]
            new_node_idx = parent_idx

    def _shift_down(self, idx):
        while idx * 2 < len(self.nodes):
            child_idx = idx * 2
            if child_idx + 1 < len(self.nodes) and self.nodes[child_idx + 1].key > self.nodes[child_idx].key:
                child_idx += 1

            if self.nodes[idx].key >= self.nodes[child_idx].key:
                break

            self.nodes[idx], self.nodes[child_idx] = self.nodes[child_idx], self.nodes[idx]
            idx = child_idx

    def push(self, value , key):
        self.counter += 1
        new_node_idx = len(self.nodes)
        self.nodes.append(Item(key, value))
        self._heapify(new_node_idx)

    def peek(self):
        if len(self.nodes) > 1:
            return self.nodes[1].value
        else:
            raise IndexError

    def pop(self):
        if len(self.nodes) <= 1:
            raise LookupError('pop from empty queue')

        max_item = self.nodes[1]
        last_item = self.nodes.pop()
        self.counter -= 1

        if len(self.nodes) > 1:
            self.nodes[1] = last_item # Move last element to root
            self._shift_down(1)        # Fix the heap downwards

        return max_item.value

if __name__ == "__main__":
    pq = PriorityQueue()

    print("Pushing items...")
    pq.push(1.50, "Orange")
    pq.push(0.75, "Apple")
    pq.push(2.99, "Pitaya")
    pq.push(1.20, "Banana")

    print(f"Highest priority (Alphabetical): {pq.peek()}")

    print("\nPopping items in order of priority:")
    while True:
        try:
            val = pq.pop()
            print(f"Extracted fruit with cost: {val}")
        except LookupError:
            break


