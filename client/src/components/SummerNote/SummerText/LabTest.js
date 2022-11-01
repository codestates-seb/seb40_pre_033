// import React from 'react';
// import { Button, Header, Image, Modal } from 'semantic-ui-react';

// export default function LabTest() {
//   const [open, setOpen] = React.useState(false);

//   return (
//     <Modal
//       onClose={() => setOpen(false)}
//       onOpen={() => setOpen(true)}
//       open={open}
//       trigger={<Button variant="primary">Show Modal</Button>}
//     >
//       <Modal.Header>Select a Photo</Modal.Header>
//       <Modal.Content image>
//         <Image size="medium" src="/images/avatar/large/rachel.png" wrapped />
//         <Modal.Description>
//           <Header>Default Profile Image</Header>
//           <p>
//             We have found the following gravatar image associated with your
//             address.
//           </p>
//           <p>Is it okay to use this photo?</p>
//         </Modal.Description>
//       </Modal.Content>
//       <Modal.Actions>
//         <Button color="black" onClick={() => setOpen(false)}>
//           Nope
//         </Button>
//         <Button
//           content="Yep, that's me"
//           labelPosition="right"
//           icon="checkmark"
//           onClick={() => setOpen(false)}
//           positive
//         />
//       </Modal.Actions>
//     </Modal>
//   );
// }
