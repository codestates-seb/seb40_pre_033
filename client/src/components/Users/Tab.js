import styled from 'styled-components';
import { AiOutlineSearch } from 'react-icons/ai';
import { useState } from 'react';
const FilterContainer = styled.div`
  display: flex;
  justify-content: space-between;
  flex-direction: row;
  /* border: 1px solid pink; */
  margin: 0;
  padding: 0;
  flex-flow: wrap;
  margin-bottom: 20px;
  @media screen and (max-width: 982px) {
    display: flex;
    row-gap: 12px;
    flex-direction: column;
    margin-bottom: 10px;
  }
  @media screen and (max-width: 640px) {
    margin-bottom: 0px;
  }
  > .input-search {
    display: flex;
    max-width: calc(8rem * 3);
    margin: 0;
    flex-direction: row;
    align-items: stretch;
    height: 100%;
    flex-wrap: nowrap;
    flex-shrink: 10000;
    flex-grow: 1;
    position: relative;
    padding: 5px 5px;
    background-color: #ffffff;
    border: 1px solid #babfc4;
    border-radius: 4px;
    box-sizing: inherit;
    &:focus-within {
      box-shadow: 0px 0px 3px 3px rgba(107, 186, 247, 0.5);
      border: none;
      outline: 0;
    }

    > input {
      color: hsl(210, 8%, 5%);
      font-size: 12px;
      flex-grow: 1;

      margin: 0;
      border: none;
      :focus {
        outline: none;
      }
    }
  }
  > .sort {
    display: flex;
    justify-content: space-between;
    align-items: center;
    @media screen and (max-width: 640px) {
      font-size: 15.4px;
      flex-direction: column !important;
      align-items: flex-start;
      gap: 10px;
      margin-bottom: 10px;
    }
    > .question-sort {
      > button {
        font-size: 13px;
        border: 1px solid hsl(210, 8%, 55%);
        padding: 8px 10px;
        color: hsl(210, 8%, 45%);
        @media screen and (max-width: 640px) {
          flex-direction: column-reverse;
        }
        cursor: pointer;
        :first-child {
          border-radius: 3px;
          border-top-right-radius: 0;
          border-bottom-right-radius: 0;
        }
        :last-child {
          border-radius: 3px;
          border-top-left-radius: 0;
          border-bottom-left-radius: 0;
        }
        :not(:last-child) {
          border-right: none;
        }
        :hover {
          background-color: hsl(210, 8%, 97.5%);
        }
        &.is-selected {
          background-color: hsl(210, 8%, 90%);
          color: hsl(210, 8%, 25%);
          border: 1px solid hsl(210, 8%, 55%);
          :not(:last-child) {
            border-right: none;
          }
        }
      }
    }
  }
`;
export const Tab = () => {
  // ✨ 정렬
  const [selected, setSelected] = useState('New users');
  // redux?
  const sortClick = (e) => {
    switch (e.target.value) {
      case 'Reputation':
        setSelected('Reputation');
        break;
      case 'New users':
        setSelected('New users');
        break;
      case 'Voters':
        setSelected('Voters');
        break;
      case 'Editors':
        setSelected('Editors');
        break;
      case 'Moderators':
        setSelected('Moderators');
        break;
      default:
        break;
    }
  };
  return (
    <FilterContainer>
      <div className="input-search">
        <AiOutlineSearch size={20} color="#838C95" />
        <input
          type="text"
          className="logo-search"
          placeholder="Filter by user"
        />
      </div>
      <div className="sort">
        <div className="question-sort">
          <button
            onClick={sortClick}
            className={selected === 'Reputation' ? 'is-selected' : ''}
            value={'Reputation'}
          >
            Reputation
          </button>
          <button
            onClick={sortClick}
            className={selected === 'New users' ? 'is-selected' : ''}
            value={'New users'}
          >
            New users
          </button>
          <button
            onClick={sortClick}
            className={selected === 'Voters' ? 'is-selected' : ''}
            value={'Voters'}
          >
            Voters
          </button>
          <button
            onClick={sortClick}
            className={selected === 'Editors' ? 'is-selected' : ''}
            value={'Editors'}
          >
            Editors
          </button>
          <button
            onClick={sortClick}
            className={selected === 'Moderators' ? 'is-selected' : ''}
            value={'Moderators'}
          >
            Moderators
          </button>
        </div>
      </div>
    </FilterContainer>
  );
};
