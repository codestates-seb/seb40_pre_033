import styled from 'styled-components';
import { QuestionContent } from './QuestionContent';
import { QuestionLeftBar } from './QuestionLeftBar';

export const LiBlock = styled.li`
  padding: 16px 0;
  border-bottom: 1px solid hsl(201, 8%, 90%);

  > div {
    display: flex;
  }

  > a {
    margin-left: 52px;
    padding: 0 3px 2px 3px;
    font-size: 13px;
    color: hsl(210, 8%, 55%);

    &:active,
    &:hover {
      color: var(--theme-link-color-hover);
    }
  }
`;

export const QuestionTemplate = () => {
  return (
    <LiBlock>
      <div>
        <QuestionLeftBar />
        <QuestionContent />
      </div>
      {/* eslint-disable-next-line jsx-a11y/anchor-is-valid */}
      <a href="#">Add a comment</a>
    </LiBlock>
  );
};
