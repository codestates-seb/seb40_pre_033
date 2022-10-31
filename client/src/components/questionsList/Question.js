import { QuestionTags } from './style';
import { useSelector } from 'react-redux';

export const Question = (type) => {
  let question = useSelector((state) => state.questionReducer);
  let posts = useSelector((state) => state.postsReducer);

  return (
    <div className="questions">
      <div className="post-summury">
        <div>{question.vote} votes</div>
        <div>{question.comments.length} answers</div>
        <div>0 views</div>
      </div>
      <div className="question-list">
        <h2 className="question-title">
          {/* /questions/id */}
          <a href="/questions/1">
            {/* How to prevent 2 objects from splitting on top of another */}
            {posts.posts[type.idx].title}
          </a>
        </h2>
        <div className="question-content">
          {/* Hello so Im creating a game (since i recently started studying
          javascript). The game is Asteroids the code is basically the same
          as freeCodeCamp video only some differences are the scoring system
          ... */}
          {posts.posts[type.idx].content}
        </div>
        <div className="question-information">
          <QuestionTags>
            {posts.posts[type.idx].tags.map((tag, idx) => (
              <li key={idx}>
                {/* eslint-disable-next-line jsx-a11y/anchor-is-valid */}
                <a href="#">{tag}</a>
              </li>
            ))}
          </QuestionTags>
          <div className="question__avatar--wrapper">
            <img
              className="discussion__avatar--image"
              src={posts.posts[type.idx].image}
              alt=""
            />
            {`${
              posts.posts[type.idx].user
            } asked ${new Date().toLocaleDateString()}`}
          </div>
        </div>
      </div>
    </div>
  );
};