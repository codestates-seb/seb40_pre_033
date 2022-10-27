import styled from 'styled-components';
import { PencilSvg } from '../../assets/images/QuestionSvg';

const Block = styled.ul`
  margin: 12px 0 0 52px;
  padding: 0 16px 10px 0;
  border-top: 1px solid hsl(201, 8%, 90%);

  li {
    padding: 6px;
    border-bottom: 1px solid hsl(201, 8%, 95%);

    > span {
      font-size: 13px;
    }
    > div {
      display: flex;
      align-items: center;

      span:nth-of-type(2) {
        margin: 0 3px;
        font-size: 13px;
        color: #9199a1;
      }
    }
  }
`;

export const UserButton = styled.button`
  padding: 1px 5px;
  background-color: #d9eaf7;
  color: #0074cc;
  font-size: 13px;
  border-radius: 3px;

  &:active,
  &:hover {
    color: #0a95ff;
  }
`;

export const AnswerComments = () => {
  return (
    <Block>
      <li>
        <span>
          This is close, but it changes the behavior of the marquee. The marquee
          is scrollable because it&#39;s in the scrollview and when you put the
          modifier on the scrollview, it causes Buttons generated by the ForEach
          to be cut off. I think this is happening because the width of the view
          containing all the buttons is greater than the width of the screen,
          which causes it to crop because it&#39;s in a scrollview. This cut off
          behavior doesn&#39;t happen when the modifier is on the inner
          HStack...not sure how to fix it.
        </span>
        <div>
          <span>
            -&nbsp; <UserButton>nickcoding</UserButton>
          </span>
          <span>Oct 18 at 16:23</span>
          <PencilSvg />
        </div>
      </li>
    </Block>
  );
};
