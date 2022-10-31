import styled from 'styled-components';
import { QuestionHeader } from '../components/Question/QuestionHeader';
import { QuestionTemplate } from '../components/Question/QuestionTemplate';
import { Answers } from '../components/Answer/Answers';
import { SidebarWidget } from '../components/Home/SidebarWidget/SidebarWidget';
// import { useDispatch } from 'react-redux';
// import { getQuestion } from '../redux/actions/questionAction';
// import { useEffect } from 'react';
// import { useParams } from 'react-router-dom';

const Container = styled.div`
  width: calc(100% - 164px);
  max-width: 1100px;
  padding: 24px;

  > div {
    display: flex;
  }

  // Mobile
  @media screen and (max-width: 640px) {
    width: 100%;
    padding: 24px 16px;
  }
  // Tablet
  @media screen and (max-width: 980px) {
    width: 100%;
    padding: 24px 16px;
  }
`;

const Content = styled.div`
  width: calc(100% - 300px - 24px);
  /* border: 2px solid aquamarine; */

  // Mobile
  @media screen and (max-width: 640px) {
    width: 100%;
  }
  // Tablet
  @media screen and (max-width: 980px) {
    width: 100%;
  }
`;

export const QuestionPage = () => {
  // const dispatch = useDispatch();
  // const { id } = useParams();

  // useEffect(() => {
  //   console.log('GET QUESTION');
  //   dispatch(getQuestion(id));
  // }, []);

  return (
    <Container>
      <QuestionHeader />
      <div>
        <Content>
          <QuestionTemplate />
          <Answers />
        </Content>
        <aside>
          <section></section>
          <SidebarWidget />
        </aside>
      </div>
    </Container>
  );
};
