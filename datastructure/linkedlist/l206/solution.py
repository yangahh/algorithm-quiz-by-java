from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
    def __str__(self) -> str:
        result = '['
        head = self
        while head:
            result += f'{head.val}'
            if head.next:
                result += ', '
            head = head.next
        result += ']'
        return result


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return []

        prev, now = None, head
        while True:
            if not now:
                break
            temp = now.next  # 이전 포인터를 임시 저장 -> 다음 루프때 써야 함
            now.next = prev

            prev = now  # 이전 노드를 next값을 바꾼(포인터를 앞 노드를 가리키도록 변경) 현재 노드로 갱신
            now = temp  # now값을 원래 next였던 노드로 갱신

        return prev 


head = ListNode(val=1, next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=4, next=ListNode(val=5)))))
solution = Solution()
result = solution.reverseList(head)
print(result)