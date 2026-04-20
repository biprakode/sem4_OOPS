# Name - Biprarshi Biswas
# Roll No - 002410501094
# BCSE-II A3

# Question:
# Implement a priority queue that sorts items by a given priority and always returns the
# item with the highest priority on each pop operation.

class Item:
    # tiny wrapper that keeps the priority and the actual payload together
    def __init__(self, key, value):
        self.key = key
        self.value = value


class PriorityQueue(object):
    def __init__(self):
        # index 0 is a sentinel so parent/child math stays simple
        self.nodes: list[Item] = [Item(None, None)]
        self.counter = 0

    def _heapify(self, new_node_idx):
        # bubble the new node up until the heap property is satisfied
        while 1 < new_node_idx:
            new_node = self.nodes[new_node_idx]
            parent_idx = new_node_idx // 2
            parent_node = self.nodes[parent_idx]

            # parent already has higher priority -> we're done
            if parent_node.key >= new_node.key:
                break

            # otherwise swap with parent and keep climbing
            self.nodes[new_node_idx], self.nodes[parent_idx] = self.nodes[parent_idx], self.nodes[new_node_idx]
            new_node_idx = parent_idx

    def _shift_down(self, idx):
        # used after popping - push the root down to its correct spot
        while idx * 2 < len(self.nodes):
            child_idx = idx * 2
            # pick the larger of the two children
            if child_idx + 1 < len(self.nodes) and self.nodes[child_idx + 1].key > self.nodes[child_idx].key:
                child_idx += 1

            # correct spot - stop
            if self.nodes[idx].key >= self.nodes[child_idx].key:
                break

            # otherwise swap with that child and continue downward
            self.nodes[idx], self.nodes[child_idx] = self.nodes[child_idx], self.nodes[idx]
            idx = child_idx

    def push(self, value, key):
        # append then fix the heap upward
        self.counter += 1
        new_node_idx = len(self.nodes)
        self.nodes.append(Item(key, value))
        self._heapify(new_node_idx)

    def peek(self):
        # show the top priority without removing it
        if len(self.nodes) > 1:
            return self.nodes[1].value
        else:
            raise IndexError

    def pop(self):
        # remove and return the highest priority element
        if len(self.nodes) <= 1:
            raise LookupError('pop from empty queue')

        max_item = self.nodes[1]
        last_item = self.nodes.pop()
        self.counter -= 1

        if len(self.nodes) > 1:
            self.nodes[1] = last_item  # move last element to root
            self._shift_down(1)        # fix the heap downwards

        return max_item.value


if __name__ == "__main__":
    pq = PriorityQueue()

    # push a few fruits at different prices
    print("Pushing items...")
    pq.push(1.50, "Orange")
    pq.push(0.75, "Apple")
    pq.push(2.99, "Pitaya")
    pq.push(1.20, "Banana")

    print(f"Highest priority (Alphabetical): {pq.peek()}")

    # drain the queue and watch priorities come out in order
    print("\nPopping items in order of priority:")
    while True:
        try:
            val = pq.pop()
            print(f"Extracted fruit with cost: {val}")
        except LookupError:
            break
