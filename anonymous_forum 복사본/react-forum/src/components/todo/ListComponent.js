import { useEffect, useState } from 'react';
import { getCategory, getList } from '../../api/todoApi';
import useCustomMove from '../hooks/useCustomMove';
import './ListComponent.css';

const initState = {
  dtoList: [],
  pageNumList: [],
  pageRequestDTO: null,
  prev: false,
  next: false,
  totoalCount: 0,
  prevPage: 0,
  nextPage: 0,
  totalPage: 0,
  current: 0,
};

const ListComponent = () => {
  const { moveToRead } = useCustomMove();
  const [serverData, setServerData] = useState(initState);

  useEffect(() => {
    getList().then((data) => {
      setServerData({
        ...initState,
        dtoList: data.data.list,
      });
    });
  }, []);

  const handleClickCate = (code) => {
    getCategory({ code }).then((data) => {
      setServerData({
        ...initState,
        dtoList: data.data.list,
      });
    });
  };

  return (
    <div className="ListContainer">
      <div className="ListWarp">
        <div className="ListMenu">
          <div className="categoryWarp">
            <div className="categoryContent">
              <button
                className="categoryContentBtn"
                onClick={() => handleClickCate(1)}
              >
                수업
              </button>
            </div>
            <div className="categoryContent">
              <button
                className="categoryContentBtn"
                onClick={() => handleClickCate(2)}
              >
                교사
              </button>
            </div>
            <div className="categoryContent">
              <button
                className="categoryContentBtn"
                onClick={() => handleClickCate(3)}
              >
                학생
              </button>
            </div>
            <div className="categoryContent">
              <button
                className="categoryContentBtn"
                onClick={() => handleClickCate(4)}
              >
                잡담
              </button>
            </div>
          </div>
          <ul className="ListMenuUl">
            <li className="ListMenuLi">WRITER</li>
            <li className="ListMenuLi">TITLE</li>
            <li className="ListMenuLi">DATE</li>
          </ul>
        </div>

        {serverData.dtoList.map((board) => (
          <div
            key={board.detailed_code}
            className="ListContent"
            onClick={() => moveToRead(board.detailed_code)}
          >
            <div className="List">
              <div className="ListWriter">{board.writer}</div>
              <div className="ListTitle">{board.title}</div>
              <div className="ListDate">
                {new Date(board.created_at).toLocaleDateString()}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ListComponent;
